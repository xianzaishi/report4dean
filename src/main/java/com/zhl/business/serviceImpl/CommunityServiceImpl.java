package com.zhl.business.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.business.dao.CommunityDao;
import com.zhl.business.model.Community;
import com.zhl.business.service.CommunityService;

@Service
public class CommunityServiceImpl implements CommunityService {
	@Autowired
	private CommunityDao communityDao;

	/**
	 * 查询社区
	 * 
	 * @return
	 */
	public List<Community> queryCommunity() {
		return communityDao.queryCommunity();
	}

	/**
	 * 根据id查询社区
	 * 
	 * @param id
	 * @return Community
	 */
	public Community queryCommunityById(int id) {
		return communityDao.queryCommunityById(id);
	}
}
