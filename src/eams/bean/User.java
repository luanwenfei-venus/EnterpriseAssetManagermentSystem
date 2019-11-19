package eams.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

/**
 * 用户对象类
 * 
 * @author lil
 * @version v1.0
 */
public class User {

	private Long id;

	@NotNull
	@Size(min = 5, max = 100)
	private String userName;

	@NotNull
	@Size(min = 5, max = 100)
	private String password;

	@NotNull
	@Size(min = 2, max = 30)
	private String phone;

	@NotNull
	@Email
	private String email;

	private int lock = 0;
	
	public User() {
	}

	/**
	 * 构造方法
	 * 
	 * @param userName
	 *            用户名（登录名）
	 * @param password
	 *            密码
	 * @param phone
	 *            手机号
	 * @param email
	 *            邮箱
	 */
	public User(String userName, String password, String phone, String email) {
		this(null, userName, password, phone, email);
	}

	/**
	 * 构造方法
	 * 
	 * @param id
	 *            主键
	 * @param userName
	 *            用户名（登录名）
	 * @param password
	 *            密码
	 * @param phone
	 *            手机号
	 * @param email
	 *            邮箱
	 */
	public User(Long id, String userName, String password, String phone, String email) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * 取得用户名（登录名）
	 * 注意！当JSP页面采用${user.userName}调用一个对象的属性时，会调用此方法，必须严格按照命名规则具有此方法，
	 * 不然会报找不到方法。建议采用IDE工具自动生成
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名（登录名）
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
	 * 取得ID主键
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置ID主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the lock
	 */
	public int getLock() {
		return lock;
	}

	/**
	 * @param lock the lock to set
	 */
	public void setLock(int lock) {
		this.lock = lock;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
