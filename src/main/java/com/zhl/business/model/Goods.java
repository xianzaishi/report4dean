package com.zhl.business.model;

/**
 * 商品实体类
 * 
 * @author 张宏亮
 * 
 */
public class Goods {
	/**
	 * id
	 */
	private int id;

	/**
	 * 所属店铺id
	 */
	private int shopId;

	/**
	 * 品名
	 */
	private String title;

	/**
	 * 摘要
	 */
	private String brief;

	/**
	 * 原价
	 */
	private String price;

	/**
	 * 售价
	 */
	private String salePrice;

	/**
	 * 详情
	 */
	private String detail;

	/**
	 * 图片id
	 */
	private int picId;

	/**
	 * 规格
	 */
	private String specifiation;

	/**
	 * 种类
	 */
	private String type;

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
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

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getSpecifiation() {
		return specifiation;
	}

	public void setSpecifiation(String specifiation) {
		this.specifiation = specifiation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
