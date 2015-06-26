package com.zhl.business.service;

import java.util.List;

import com.zhl.business.dto.RepairDto;
import com.zhl.business.model.Repair;
import com.zhl.business.model.RepairPic;
import com.zhl.business.model.RepairReply;

public interface RepairService {

	/**
	 * 根据status查询未处理的报修
	 * 
	 * @return
	 */
	public List<Repair> queryRepairListByStatus(int status, int start, int maxResults);

	/**
	 * 更新报修信息
	 * 
	 * @param repair
	 */
	public void updateRepairStatusById(Repair repair);

	/**
	 * 阅读等级增加1
	 * 
	 * @param repairId
	 */
	public void increaseReadlevel(int repairId);

	/**
	 * 根据status查询报修数
	 * 
	 * @param status
	 * @return int 报修数
	 */
	public int queryRepairCountByStatus(int status);

	/**
	 * 根据readLevel查询未处理的报修
	 * 
	 * @param readLevel
	 * @param start
	 * @param maxResults
	 * @return List<Repair>
	 */
	public List<Repair> queryUnhandledByReadLevel(int readLevel, int start, int maxResults);

	/**
	 * 根据readLevel查询未处理的报修数
	 * 
	 * @param readLevel
	 * @return int 报修数
	 */
	public int queryUnhandledCountByReadLevel(int readLevel);

	/**
	 * 根据readLevel查询处理的报修
	 * 
	 * @param readLevel
	 * @param start
	 * @param maxResults
	 * @return List<Repair>
	 */
	public List<Repair> queryHandledByReadLevel(int readLevel, int start, int maxResults);

	/**
	 * 根据readLevel查询处理的报修数
	 * 
	 * @param readLevel
	 * @return int 报修数
	 */
	public int queryHandledCountByReadLevel(int readLevel);

	/**
	 * 根据id查询报修信息
	 * 
	 * @param id
	 * @return
	 */
	public RepairDto queryRepairDtoById(int id);

	/**
	 * 添加回复
	 * 
	 * @param reply
	 */
	public void addRepairReply(RepairReply reply);

	/**
	 * 根据报修id查回复
	 * 
	 * @param repairId
	 * @return
	 */
	public List<RepairReply> queryReplyByRepairId(int repairId);

	/**
	 * 添加报修图片
	 * 
	 * @param RepairPic
	 * @return id
	 */
	public int addRepairPic(RepairPic repairPic);

	/**
	 * 添加报修
	 * 
	 * @param repair
	 */
	public void addRepair(Repair repair);
}
