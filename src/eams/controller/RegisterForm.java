package eams.controller;

import eams.bean.User;

/**
 * 用户注册表单类，是作用view层的对象类，便于传递数据
 * 
 * @author lil
 * @version v1.0
 */
public class RegisterForm {

	private String phone;
	private String userName;
	private String password;
	private String passwordConfirm;
	private String email;




	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

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
	 * 取得邮箱
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置邮箱
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 转换到用户对象
	 * 
	 * @return user
	 */
	public User toUser() {
		return new User(userName, password, phone, email);
	}

}
