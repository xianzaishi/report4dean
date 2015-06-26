package com.zhl.business.model;

/**
 * 角色实体类
 * 
 * @author 张宏亮
 * 
 */
public class Role {

	/**
	 * id
	 */
	private int id;

	/**
	 * 角色
	 */
	private String name;

	/**
	 * 角色描述
	 */
	private String modelName;

	/**
	 * 读阅等级 0:全部用户
	 */
	private int readLevel;

	public int getReadLevel() {
		return readLevel;
	}

	public void setReadLevel(int readLevel) {
		this.readLevel = readLevel;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

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
}
