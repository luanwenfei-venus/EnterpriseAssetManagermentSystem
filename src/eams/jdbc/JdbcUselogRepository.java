package eams.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import eams.bean.User;
import eams.bean.Uselog;
import eams.controller.PaginationSupport;
import eams.db.UselogRepository;

/**
 * 申请资源库接口的jdbc实现类
 * 
 * @author lil
 * @version v1.0
 */
@Repository
public class JdbcUselogRepository implements UselogRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcUselogRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public long count() {
		return jdbc.queryForLong("select count(id) from Uselog");
	}

	@Override
	public Uselog findOne(long id) {
		try {
			return jdbc.queryForObject(SELECT_USELOG_BY_ID, new UselogRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Uselog> findByUserId(long userId) {
		return jdbc.query(SELECT_USELOGS_BY_USER_ID, new UselogRowMapper(), userId);
	}

	@Override
	public Uselog save(Uselog uselog) {
		long uselogId = insertUselogAndReturnId(uselog);
		return new Uselog(uselogId, uselog.getDeviceId(), uselog.getDeviceName(), uselog.getUserId(),uselog.getUserName(),uselog.getUseday());
	}

	private long insertUselogAndReturnId(Uselog uselog) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbc).withTableName("Uselog");
		jdbcInsert.setGeneratedKeyName("id");
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("deviceID", uselog.getDeviceId());
		args.put("deviceName", uselog.getDeviceName());
		args.put("userID", uselog.getUserId());
		args.put("userName", uselog.getUserName());
		args.put("useday", uselog.getUseday());
		args.put("checked",uselog.getChecked());
		long uselogId = jdbcInsert.executeAndReturnKey(args).longValue();
		return uselogId;
	}

	@Override
	public PaginationSupport<Uselog> findPage(int pageNo, int pageSize) {
		int totalCount = (int) count();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Uselog>(new ArrayList<Uselog>(0), 0);

		List<Uselog> items = jdbc.query(SELECT_PAGE_USELOGS, new UselogRowMapper(), pageSize, startIndex);
		PaginationSupport<Uselog> ps = new PaginationSupport<Uselog>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public void delete(long id) {
		jdbc.update("delete from Uselog where id=?", id);
	}

	@Override
	public void getUselogChecked(long id) {
		jdbc.update("update Uselog set checked=1 where id=?", id);
	}
	
	private static final class UselogRowMapper implements RowMapper<Uselog> {
		public Uselog mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("id");
			long deviceId = rs.getLong("deviceId");
			String deviceName = rs.getString("deviceName");
			long userId = rs.getLong("userId");
			String userName = rs.getString("userName");
			Date useday = rs.getDate("useday");
			int checked = rs.getInt("checked");
			Uselog uselog = new Uselog(id, deviceId, deviceName, userId, userName, useday, checked);
			return uselog;
		}
	}

	private static final String SELECT_USELOG = "select id,deviceId,deviceName,userId,userName,useday,checked from uselog";
	private static final String SELECT_USELOG_BY_ID = SELECT_USELOG + " where id=?";
	private static final String SELECT_USELOGS_BY_USER_ID = SELECT_USELOG
			+ " where userid=?";
	private static final String SELECT_PAGE_USELOGS = SELECT_USELOG
			+ " order by useday desc limit ? offset  ?";

}
