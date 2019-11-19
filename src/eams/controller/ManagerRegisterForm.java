package eams.controller;

import eams.bean.Manager;

/**
 * 管理员注册表单类，是作用view层的对象类，便于传递数据
 * 
 * @author lil
 * @version v1.0
 */
public class ManagerRegisterForm {

	private String userName;
	private String password;
	private String passwordConfirm;

	/**
	 * 取得登录名
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置登录名
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

	/**
	 * 取得密码确认
	 * 
	 * @return
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * 设置密码确认
	 * 
	 * @param passwordConfirm
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}


	/**
	 * 转换到管理员对象
	 * 
	 * @return
	 */
	public Manager toManager() {
		return new Manager(userName, password);
	}

}
