package eams.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import eams.bean.User;
import eams.controller.PaginationSupport;
import eams.db.UserRepository;

/**
 * 用户资源库接口的jdbc实现类
 * 
 * @author lil
 * @version v1.0
 */
@Repository
public class JdbcUserRepository implements UserRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcUserRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public User save(User user) {
		jdbc.update(INSERT_SPITTER, user.getUserName(), user.getPassword(), user.getPhone(), user.getEmail());
		return user;
	}

	@Override
	public User findByUserName(String userName) {
		User user = null;
		try {
			user = jdbc.queryForObject(SELECT_SPITTER + " where username=?", new UserRowMapper(), userName);
		} catch (DataAccessException e) {
		}
		return user;
	}

	@Override
	public User findByUserName(String userName, String password) {
		User user = null;
		try {
			user = jdbc.queryForObject(SELECT_SPITTER + " where username=? and password=?", new UserRowMapper(),
					userName, password);
		} catch (DataAccessException e) {
		}
		return user;
	}

	@Override
	public long count() {
		return jdbc.queryForLong("select count(id) from User");
	}

	@Override
	public User findOne(long id) {
		User user = null;
		try {
			user = jdbc.queryForObject(SELECT_SPITTER + " where id=?", new UserRowMapper(), id);
		} catch (DataAccessException e) {
		}
		return user;
	}

	@Override
	public PaginationSupport<User> findPage(int pageNo, int pageSize) {
		int totalCount = (int) count();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<User>(new ArrayList<User>(0), 0);

		List<User> items = jdbc.query(SELECT_PAGE_SPITTERS, new UserRowMapper(), pageSize, startIndex);
		PaginationSupport<User> ps = new PaginationSupport<User>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public List<User> findAll() {
		return jdbc.query(SELECT_SPITTER + " order by id", new UserRowMapper());
	}

	private static class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getLong("id"), rs.getString("username"), null, rs.getString("phone"),
					rs.getString("email"));
		}
	}
	@Override
	public void delete(long id) {
		jdbc.update("delete from user where id=?", id);
	}
	@Override
	public void lock(long userId) {
		jdbc.update("update user set lock=1 where id=?",userId);
	}
	
	@Override
	public void unlock(long userId) {
		jdbc.update("update user set lock=0 where id=?",userId);
	}
	
	private static final String INSERT_SPITTER = "insert into User (username, password, phone, email) values (?, ?, ?, ?)";

	private static final String SELECT_SPITTER = "select id, username, phone, email from User";

	private static final String SELECT_PAGE_SPITTERS = SELECT_SPITTER + " order by id limit ? offset  ?";
}
