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

import eams.bean.Asset;
import eams.db.AssetRepository;
import eams.controller.PaginationSupport;
@Repository
public class JdbcAssetRespository implements AssetRepository{
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return jdbc.queryForLong("select count(id) from Asset");
	}

	@Override
	public Asset save(Asset asset) {
		// TODO Auto-generated method stub
		jdbc.update(INSERT_ASSET,asset.getDeviceName(),asset.getBrand(),asset.getDeviceType(),asset.getDay(),asset.getBrand());
		return asset;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		jdbc.update("delete fro asset where id ="+id);
	}

	@Override
	public void updateById(boolean status, long id) {
		// TODO Auto-generated method stub
		jdbc.update("update asset set status = false where id ="+id);
	}

	@Override
	public Asset findById(long id) {
		// TODO Auto-generated method stub
		Asset asset = null;
		try {
			asset = jdbc.queryForObject(SELECT_ASSET + "where id=?",new AssetRowMapper(),id);
		}catch (DataAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return asset;
	}

	@Override
	public List<Asset> findAll() {
		// TODO Auto-generated method stub
		return jdbc.query(SELECT_ASSET + "order by id ", new AssetRowMapper());
	}
	
	
	@Override
	public void returnAsset(long assetId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 *分页查询
	 */
	@Override
	public PaginationSupport<Asset> findPage(int pageNo,int pageSize){
		int totalCount = (int) count();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Asset>(new ArrayList<Asset>(0), 0);

		List<Asset> items = jdbc.query(SELECT_PAGE_ASSET, new AssetRowMapper(), pageSize, startIndex);
		PaginationSupport<Asset> ps = new PaginationSupport<Asset>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	
	
	private static class AssetRowMapper implements RowMapper<Asset> {
		public Asset mapRow(ResultSet Result, int rowNum) throws SQLException {
			return new Asset(Result.getLong("id"), Result.getString("deviceName"), Result.getString("brand"),
					Result.getString("deviceType"), Result.getDate("day"), Result.getBoolean("status"));
		}
	}
	
	private static final String SELECT_ASSET = "select id, devicename, brand, devicetype, day, status  from asset ";
	
	private static final String INSERT_ASSET = "insert into asset (devicename, brand, devicetype, day, status) value (?, ?, ?, ?, ? ) ";

	private static final String SELECT_PAGE_ASSET = SELECT_ASSET + " order by id asc limit ? offset  ?";
}
