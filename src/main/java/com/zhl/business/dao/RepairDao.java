package com.zhl.business.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhl.business.dto.RepairDto;
import com.zhl.business.model.Repair;
import com.zhl.business.model.RepairPic;
import com.zhl.business.model.RepairReply;

@Repository
public class RepairDao extends BaseDao {
	/**
	 * 根据id查询报修信息
	 * 
	 * @param id
	 * @return
	 */
	public RepairDto queryRepairDtoById(int id) {
		return (RepairDto) getSqlMapClientTemplate().queryForObject("repair.queryRepairDtoById", id);
	}

	/**
	 * 更新报修信息
	 * 
	 * @param repair
	 */
	public void updateRepairStatusById(Repair repair) {
		getSqlMapClientTemplate().update("repair.updateRepairStatusById", repair);
	}

	/**
	 * 阅读等级增加1
	 * 
	 * @param repairId
	 */
	public void increaseReadlevel(int repairId) {
		getSqlMapClientTemplate().update("repair.increaseReadlevel", repairId);
	}

	/**
	 * 根据status查询未处理的报修
	 * 
	 * @return
	 */
	public List<Repair> queryRepairListByStatus(int status, int start, int maxResults) {
		return (List<Repair>) getSqlMapClientTemplate().queryForList("repair.queryRepairListByStatus", status, start, maxResults);
	}

	/**
	 * 根据status查询报修数
	 * 
	 * @param status
	 * @return
	 */
	public int queryRepairCountByStatus(int status) {
		return (Integer) getSqlMapClientTemplate().queryForObject("repair.queryRepairCountByStatus", status);
	}

	/**
	 * 根据readLevel查询未处理的报修
	 * 
	 * @param readLevel
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<Repair> queryUnhandledByReadLevel(int readLevel, int start, int maxResults) {
		return (List<Repair>) getSqlMapClientTemplate().queryForList("repair.queryUnhandledByReadLevel", readLevel, start, maxResults);
	}

	/**
	 * 根据readLevel查询未处理的保修数
	 * 
	 * @param readLevel
	 * @return
	 */
	public int queryUnhandledCountByReadLevel(int readLevel) {
		return (Integer) getSqlMapClientTemplate().queryForObject("repair.queryUnhandledCountByReadLevel", readLevel);
	}

	/**
	 * 根据readLevel查询处理的报修
	 * 
	 * @param readLevel
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<Repair> queryHandledByReadLevel(int readLevel, int start, int maxResults) {
		return (List<Repair>) getSqlMapClientTemplate().queryForList("repair.queryHandledByReadLevel", readLevel, start, maxResults);
	}

	/**
	 * 根据readLevel查询处理的保修数
	 * 
	 * @param readLevel
	 * @return
	 */
	public int queryHandledCountByReadLevel(int readLevel) {
		return (Integer) getSqlMapClientTemplate().queryForObject("repair.queryHandledCountByReadLevel", readLevel);
	}

	/**
	 * 添加回复
	 * 
	 * @param reply
	 */
	public void addRepairReply(RepairReply reply) {
		getSqlMapClientTemplate().insert("repair.addRepairReply", reply);
	}

	/**
	 * 根据报修id查回复
	 * 
	 * @param repairId
	 * @return
	 */
	public List<RepairReply> queryReplyByRepairId(int repairId) {
		return getSqlMapClientTemplate().queryForList("repair.queryReplyByRepairId", repairId);
	}

	/**
	 * 添加报修图片
	 * 
	 * @param RepairPic
	 * @return id
	 */
	public int addRepairPic(RepairPic repairPic) {
		return (Integer) getSqlMapClientTemplate().insert("repair.addRepairPic", repairPic);
	}

	/**
	 * 添加报修
	 * 
	 * @param repair
	 */
	public void addRepair(Repair repair) {
		getSqlMapClientTemplate().insert("repair.addRepair", repair);
	}
}
