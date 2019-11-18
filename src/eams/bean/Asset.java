package eams.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Asset {
	private long id;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String deviceName;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String brand;
	
	@NotNull
	@Size(min = 5, max = 25)
	private String deviceType;
	
	@NotNull
	private Date day;
	
	@NotNull
	private boolean status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Asset(String deviceName, String brand, String deviceType, Date day, boolean status) {
		this.deviceName = deviceName;
		this.brand = brand;
		this.deviceType = deviceType;
		this.day = day;
		this.status = status;
	}

	public Asset(long id, String deviceName, String brand, String deviceType, Date day, boolean status) {
		this.id = id;
		this.deviceName = deviceName;
		this.brand = brand;
		this.deviceType = deviceType;
		this.day = day;
		this.status = status;
	}

	public Asset() {
		
	}
	
	
	
	
}
