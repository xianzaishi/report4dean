package com.zhl.business.service;

import java.util.List;

import com.zhl.business.model.Community;

public interface CommunityService {
	/**
	 * 查询社区
	 * 
	 * @return
	 */
	public List<Community> queryCommunity();

	/**
	 * 根据id查询社区
	 * 
	 * @param id
	 * @return Community
	 */
	public Community queryCommunityById(int id);
}
