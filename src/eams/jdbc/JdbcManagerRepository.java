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

import eams.bean.Manager;
import eams.controller.PaginationSupport;
import eams.db.ManagerRepository;

/**
 * 
 * @author luanwf
 *
 */
@Repository
public class JdbcManagerRepository implements ManagerRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcManagerRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return jdbc.queryForLong("select count(id) from Manager");
	}

	@Override
	public Manager save(Manager manager) {
		jdbc.update(INSERT_MANAGER, manager.getUserName(), manager.getPassword());
		return manager;
	}

	@Override
	public Manager findOne(long id) {
		// TODO Auto-generated method stub
		Manager manager =null;
		try {
			manager = jdbc.queryForObject(SELECT_MANAGER + "where id=?",new ManagerRowMapper(),id);
		}catch (DataAccessException e) {
			// TODO: handle exception
		}
		return manager;
	}

	@Override
	public Manager findByUserName(String userName) {
		// TODO Auto-generated method stub
		Manager manager = null;
		try {
			manager = jdbc.queryForObject(SELECT_MANAGER + " where username=? ", new ManagerRowMapper(),
					userName);
		} catch (DataAccessException e) {
		}
		return manager;
	}

	@Override
	public Manager findByUserName(String userName, String password) {
		// TODO Auto-generated method stub
		Manager manager = null;
		try {
			manager = jdbc.queryForObject(SELECT_MANAGER + " where username=? and password=? and isdelete=?", new ManagerRowMapper(),
					userName, password,0);
			System.out.println(userName+password);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return manager;
	}
	
	
	@Override
	public PaginationSupport<Manager> findPage(int pageNo, int pageSize) {
		int totalCount = (int) count();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Manager>(new ArrayList<Manager>(0), 0);

		List<Manager> items = jdbc.query(SELECT_PAGE_MANAGERS, new ManagerRowMapper(), pageSize, startIndex);
		PaginationSupport<Manager> ps = new PaginationSupport<Manager>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public void delete(long id) {
		jdbc.update("delete from Manager where id=?", id);
	}


	private static class ManagerRowMapper implements RowMapper<Manager> {
		public Manager mapRow(ResultSet rsResult, int rowNum) throws SQLException {
			return new Manager(rsResult.getLong("id"), rsResult.getString("userName"), rsResult.getString("password"));
		}
	}

	
	private static final String INSERT_MANAGER = "insert into manager (username, password) values (?, ?)";

	private static final String SELECT_MANAGER = "select id, username, password from manager";
	
	private static final String SELECT_PAGE_MANAGERS = SELECT_MANAGER
			+ " order by id limit ? offset  ?";
}