package eams.db;

import eams.bean.Manager;

/**
 * 
 * @author luanwf
 *
 */
public interface ManagerRepository {
	/**
	 * 获取管理员的数量
	 * @return
	 */
	long count();
	
	/**
	 * 新建一个管理员
	 * @param manager
	 * @return
	 */
	
	Manager save (Manager manager);
	
	Manager findOne(long id);
	
	Manager findByUserName(String userName);
	
	Manager findByUserName(String userName,String password);
}
