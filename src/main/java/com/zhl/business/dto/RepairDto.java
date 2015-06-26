package com.zhl.business.dto;

import java.util.Date;

/**
 * repair 数据传输对象
 * 
 * @author 张宏亮
 * 
 */
public class RepairDto {
	/**
	 * id
	 */
	private int id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 经度
	 */
	private String longitude;

	/**
	 * 纬度
	 */
	private String latitude;

	/**
	 * 小区经度
	 */
	private String communityLongitude;

	/**
	 * 小区纬度
	 */
	private String communityLatitude;

	/**
	 * 缩放等级
	 */
	private int zoom;

	/**
	 * 创建日期
	 */
	private Date createDate;

	/**
	 * 创建人id
	 */
	private int creator;

	/**
	 * 状态 0：完成处理 1：未处理 10:已处理
	 */
	private String status;

	/**
	 * 小区id
	 */
	private int communityId;

	/**
	 * 图片path
	 */
	private String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getCommunityLongitude() {
		return communityLongitude;
	}

	public void setCommunityLongitude(String communityLongitude) {
		this.communityLongitude = communityLongitude;
	}

	public String getCommunityLatitude() {
		return communityLatitude;
	}

	public void setCommunityLatitude(String communityLatitude) {
		this.communityLatitude = communityLatitude;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

}
