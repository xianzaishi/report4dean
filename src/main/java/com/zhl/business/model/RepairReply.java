package com.zhl.business.model;

import java.util.Date;

/**
 * 报修回复类
 * 
 * @author 张宏亮
 * 
 */
public class RepairReply {
	/**
	 * id
	 */
	private int id;

	/**
	 * 回复内容
	 */
	private String content;

	/**
	 * 回复时间
	 */
	private Date createDate;

	/**
	 * 回复的主题id
	 */
	private int repairId;

	/**
	 * 回复人id
	 */
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getRepairId() {
		return repairId;
	}

	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
