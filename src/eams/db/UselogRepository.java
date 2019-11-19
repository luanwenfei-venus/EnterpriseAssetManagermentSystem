package eams.db;

import java.util.List;

import eams.bean.Uselog;
import eams.controller.PaginationSupport;

/**
 * 吐槽内容资源库接口
 * 
 * @author wben
 * @version v1.0
 */
public interface UselogRepository {

	/**
	 * 取得申请数量
	 * 
	 * @return 申请数量
	 */
	long count();

	/**
	 * 依据页码和指定页面大小，返回申请列表
	 * @param pageNo 起始位置
	 * @param pageSize 每页数量
	 * @return 分页对象
	 */
	PaginationSupport<Uselog> findPage(int pageNo,int pageSize);

	/**
	 * 依据id查找申请
	 * 
	 * @param id
	 *            申请ID
	 * @return 申请
	 */
	Uselog findOne(long id);

	/**
	 * 新建一个申请
	 * 
	 * @param uselog
	 *            申请
	 * @return 已保存的申请
	 */
	Uselog save(Uselog uselog);

	/**
	 * 取得指定用户的全部申请
	 * 
	 * @param userId
	 *            用户ID
	 * @return 指定用户的全部申请
	 */
	List<Uselog> findByUserId(long userId);

	/**
	 * 删除指定ID的申请
	 * 
	 * @param id
	 *            申请ID
	 */
	void delete(long id);
	/**
	 * 审核通过指定ID的申请
	 * 
	 * @param id
	 *            申请ID
	 */
	void getUselogChecked(long id);
}
