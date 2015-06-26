package com.zhl.business.model;

/**
 * 商铺实体类
 * 
 * @author 张宏亮
 * 
 */
public class Shop {

	/**
	 * id
	 */
	private int id;

	/**
	 * 店铺名称
	 */
	private String name;

	/**
	 * 所属小区id
	 */
	private int commId;

	/**
	 * 纬度
	 */
	private String longitude;

	/**
	 * 经度
	 */
	private String latitude;

	/**
	 * 店铺图片id
	 */
	private int picId;

	/**
	 * 联系电话
	 */
	private String mobile;

	/**
	 * 联系人
	 */
	private String contacts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCommId() {
		return commId;
	}

	public void setCommId(int commId) {
		this.commId = commId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
}
