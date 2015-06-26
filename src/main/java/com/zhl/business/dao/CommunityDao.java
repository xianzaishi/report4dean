package com.zhl.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhl.business.model.Community;

/**
 * 社区Dao
 * 
 * @author 张宏亮
 * 
 */
@Repository
public class CommunityDao extends BaseDao{
	/**
	 * 查询社区
	 * 
	 * @return List<Community>
	 */
	public List<Community> queryCommunity() {
		return (List<Community>) getSqlMapClientTemplate().queryForList("community.queryCommunity");
	}

	/**
	 * 根据id查询社区
	 * 
	 * @param id
	 * @return Community
	 */
	public Community queryCommunityById(int id) {
		return (Community) getSqlMapClientTemplate().queryForObject("community.queryCommunityById", id);
	}
}
