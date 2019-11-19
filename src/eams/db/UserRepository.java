 package eams.db;

import java.util.List;

import eams.bean.User;
import eams.bean.Uselog;
import eams.controller.PaginationSupport;

/**
 * 用户资源库接口
 * 
 * @author wben
 * @version v1.0
 */
public interface UserRepository {

	/**
	 * 取得用户数量
	 * 
	 * @return
	 */
	long count();

	/**
	 * 新建一个用户
	 * 
	 * @param user
	 *            新建的用户
	 * @return 用户
	 */
	User save(User user);

	/**
	 * 依据id查找用户
	 * 
	 * @param id
	 *            用户ID
	 * @return 用户
	 */
	User findOne(long id);

	/**
	 * 依据用户名（登录名）查找用户
	 * 
	 * @param userName
	 *            用户名（登录名）
	 * @return 用户
	 */
	User findByUserName(String userName);

	/**
	 * 依据用户名（登录名），密码查找用户
	 * 
	 * @param userName
	 *            用户名（登录名）
	 * @param password
	 *            密码
	 * @return 用户
	 */
	User findByUserName(String userName, String password);

	/**
	 * 依据页码和指定页面大小，返回用户列表
	 * @param pageNo 起始位置
	 * @param pageSize 每页数量
	 * @return 分页对象
	 */
	PaginationSupport<User> findPage(int pageNo,int pageSize);
	
	/**
	 * 取得全部用户
	 * 
	 * @return 全部用户
	 */
	List<User> findAll();
	/**
	 * 删除用户
	 * @param userId
	 */
	void delete(long userId);
	/**
	 * 锁定用户
	 * @param userId
	 */
	void lock(long userId);
	/**
	 * 解锁用户
	 * @param userId
	 */
	void unlock(long userId);
}
