package eams.controller;

/**
 * 登录表单类，是作用view层的对象类，便于传递数据
 * 
 * @author lil
 * @version v1.0
 */
public class LoginForm {

	private String userName;
	private String password;

	/**
	 * 取得用户名
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 取得密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
	this.password = password;
	}

}
