package com.zhl.business.model;

import java.util.Date;

/**
 * 用户实体类
 * 
 * @author 张宏亮
 * 
 */
public class User {

	/**
	 * id
	 */
	private int id;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 出生日期
	 */
	private String birthday;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 小区id
	 */
	private String communityId;

	/**
	 * 身份证号
	 */
	private String personId;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * email
	 */
	private String email;

	/**
	 * 头像id
	 */
	private int headPicId;

	/**
	 * 注册日期
	 */
	private Date createDate;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getHeadPicId() {
		return headPicId;
	}

	public void setHeadPicId(int headPicId) {
		this.headPicId = headPicId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
