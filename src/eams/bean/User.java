package eams.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	private long id;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String userName;

	@NotNull
	@Size(min = 5, max = 25)
	private String password;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String phone;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String email;
	
	@NotNull
	private boolean lock;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public User(long id, String userName, String password, String phone, String email, boolean lock) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.lock = lock;
	}

	public User(String userName, String password, String phone, String email, boolean lock) {
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.lock = lock;
	}

	public User() {
		
	}
	
}
