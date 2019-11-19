package eams.db;
import eams.bean.Asset;
import eams.controller.PaginationSupport;

import java.util.List;

public interface AssetRepository {
	long count();
	
	/**
	 * 增加、删除、修改
	 */
	
	Asset save(Asset asset);
	
	void deleteById(long id);

	void updateById(boolean status , long id);
	
	/**
	 * 查找
	 */
	Asset findById(long id);
	
	List<Asset> findAll();

	PaginationSupport<Asset> findPage(int pageNo, int pageSize);

	void returnAsset(long assetId);
}
