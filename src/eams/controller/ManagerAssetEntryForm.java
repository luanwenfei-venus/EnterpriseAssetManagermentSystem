package eams.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import eams.bean.Asset;
import eams.bean.User;

/**
 * 资产添加表单类，是作用view层的对象类，便于传递数据
 * 
 * @author lil
 * @version v1.0
 */
public class ManagerAssetEntryForm {

	private String deviceName;
	private String brand;
	private String deviceType;
	private Date day;
	private int number;

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the date
	 */
	public Date getDay() {
		return day;
	}

	/**
	 * @param dateY the dateY to set
	 */
	public void setDay(Date day) {
		this.day = day;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * 转换成asset对象
	 * @return
	 * @throws ParseException
	 */
	public Asset toAesst() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");// 可以方便地修改日期格式

		String hehe = "2019/10/11";
		day = new Date();
		SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat.format(day.getTime());
		Asset asset = new Asset(deviceName, brand, deviceType, day);
		return asset;
	}
}
