package com.zhl.business.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.business.dao.RepairDao;
import com.zhl.business.dto.RepairDto;
import com.zhl.business.model.Repair;
import com.zhl.business.model.RepairPic;
import com.zhl.business.model.RepairReply;
import com.zhl.business.service.RepairService;

@Service
public class RepairServiceImpl implements RepairService {

	@Autowired
	private RepairDao repairDao;

	/**
	 * 根据status查询未处理的报修
	 * 
	 * @return
	 */
	public List<Repair> queryRepairListByStatus(int status, int start, int maxResults) {
		return repairDao.queryRepairListByStatus(status, start, maxResults);
	}

	/**
	 * 更新报修信息
	 * 
	 * @param repair
	 */
	public void updateRepairStatusById(Repair repair) {
		repairDao.updateRepairStatusById(repair);
	}

	/**
	 * 阅读等级增加1
	 * 
	 * @param repairId
	 */
	public void increaseReadlevel(int repairId) {
		repairDao.increaseReadlevel(repairId);
	}

	/**
	 * 根据status查询报修数
	 * 
	 * @param status
	 * @return
	 */
	public int queryRepairCountByStatus(int status) {
		return repairDao.queryRepairCountByStatus(status);
	}

	/**
	 * 根据readLevel查询未处理的报修
	 * 
	 * @param readLevel
	 * @param start
	 * @param maxResults
	 * @return List<Repair>
	 */
	public List<Repair> queryUnhandledByReadLevel(int readLevel, int start, int maxResults) {
		return repairDao.queryUnhandledByReadLevel(readLevel, start, maxResults);
	}

	/**
	 * 根据readLevel查询未处理的报修数
	 * 
	 * @param readLevel
	 * @return int 报修数
	 */
	public int queryUnhandledCountByReadLevel(int readLevel){
		return repairDao.queryUnhandledCountByReadLevel(readLevel);
	}

	/**
	 * 根据readLevel查询处理的报修
	 * 
	 * @param readLevel
	 * @param start
	 * @param maxResults
	 * @return List<Repair>
	 */
	public List<Repair> queryHandledByReadLevel(int readLevel, int start, int maxResults) {
		return repairDao.queryHandledByReadLevel(readLevel, start, maxResults);
	}

	/**
	 * 根据readLevel查询处理的报修数
	 * 
	 * @param readLevel
	 * @return int 报修数
	 */
	public int queryHandledCountByReadLevel(int readLevel) {
		return repairDao.queryHandledCountByReadLevel(readLevel);
	}

	/**
	 * 根据id查询报修信息
	 * 
	 * @param id
	 * @return RepairDto
	 */
	public RepairDto queryRepairDtoById(int id) {
		return repairDao.queryRepairDtoById(id);
	}

	/**
	 * 添加回复
	 * 
	 * @param reply
	 */
	public void addRepairReply(RepairReply reply) {
		repairDao.addRepairReply(reply);
	}

	/**
	 * 根据报修id查回复
	 * 
	 * @param repairId
	 * @return List<RepairReply>
	 */
	public List<RepairReply> queryReplyByRepairId(int repairId) {
		return repairDao.queryReplyByRepairId(repairId);
	}

	/**
	 * 添加报修图片
	 * 
	 * @param RepairPic
	 * @return id
	 */
	public int addRepairPic(RepairPic repairPic) {
		return repairDao.addRepairPic(repairPic);
	}

	/**
	 * 添加报修
	 * 
	 * @param repair
	 */
	public void addRepair(Repair repair) {
		repairDao.addRepair(repair);
	}

}
