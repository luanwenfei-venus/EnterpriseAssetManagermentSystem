package eams.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * 申请对象类
 * 
 * @author lil
 * @version v1.0
 */
public class Uselog {

	private Long id;
	private Long deviceId;
	@NotNull
	@Size(min = 5, max = 100)
	private String deviceName;
	private Long userId;
	@NotNull
	@Size(min = 5, max = 100)
	private String userName;
	private Date useday;
	private int checked = 0;

	/**
	 * @param id
	 * @param deviceId
	 * @param deviceName
	 * @param userId
	 * @param UserName
	 * @param message
	 * @param userday
	 * @param checked
	 */
	public Uselog(Long deviceId, String deviceName, Long userId, String userName, Date useday) {

		this.id = null;
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.userId = userId;
		this.userName = userName;
		this.useday = useday;

	}

	public Uselog(Long id, Long deviceId, String deviceName, Long userId, String userName, Date useday) {

		this.id = id;
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.userId = userId;
		this.userName = userName;
		this.useday = useday;
	}

	public Uselog(Long id, Long deviceId, String deviceName, Long userId, String userName, Date useday, int checked) {

		this.id = id;
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.userId = userId;
		this.userName = userName;
		this.useday = useday;
		this.checked = checked;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the checked
	 */
	public int getChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(int checked) {
		this.checked = checked;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the deviceId
	 */
	public Long getDeviceId() {
		return deviceId;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the useday
	 */
	public Date getUseday() {
		return useday;
	}

}
