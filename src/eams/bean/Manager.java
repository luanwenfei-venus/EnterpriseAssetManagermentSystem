package eams.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author luanwf
 */
public class Manager {
	private long id;

	@NotNull
	@Size(min = 5, max = 25)
	private String userName;

	@NotNull
	@Size(min = 5, max = 25)
	private String password;

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

	public Manager(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Manager(long id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
}
