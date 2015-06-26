package com.zhl.business.controller;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhl.business.constant.Url;
import com.zhl.business.constant.View;
import com.zhl.business.dto.RepairDto;
import com.zhl.business.model.Community;
import com.zhl.business.model.Repair;
import com.zhl.business.model.RepairPic;
import com.zhl.business.model.RepairReply;
import com.zhl.business.model.Role;
import com.zhl.business.model.User;
import com.zhl.business.service.CommunityService;
import com.zhl.business.service.RepairService;
import com.zhl.business.service.UserService;
import com.zhl.business.util.Utils;

@Controller
public class RepairController {

	@Autowired
	private RepairService repairService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommunityService communityService;

	private final String REPAIR_DETAIL_URL = "/repair/detail/id/";

	private final String REPAIR_UNHANDLED_URL = "/repair/index/page/1";

	/**
	 * 报修主页(未处理)
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.REPAIR_INDEX)
	public String index(@PathVariable int page, HttpServletRequest request, ModelMap model) {
		//获得readLevel
		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("id").toString());
		Role role = new Role();
		role = userService.queryRoleByUserId(userId);
		int readLevel = role.getReadLevel();

		List<Repair> repairList = new LinkedList<Repair>();
		repairList = repairService.queryUnhandledByReadLevel(readLevel, (page - 1) * 8, 8);
		int count = repairService.queryUnhandledCountByReadLevel(readLevel);

		model.addAttribute("repairList", repairList);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("flag", "unhandled");
		return View.RepairIndexView;
	}

	/**
	 * 报修主页(已处理)
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPAIR_HANDLED_INDEX)
	public String handledIndex(@PathVariable int page, ModelMap model) {
		List<Repair> repairList = new LinkedList<Repair>();
		repairList = repairService.queryRepairListByStatus(10, (page - 1) * 8, 8);
		int count = repairService.queryRepairCountByStatus(10);

		model.addAttribute("repairList", repairList);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("flag", "handled");
		return View.RepairIndexView;
	}

	/**
	 * 报修详细页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPAIR_DETAIL)
	public String detail(@PathVariable int id, ModelMap model) {
		RepairDto repairDto = new RepairDto();
		repairDto = repairService.queryRepairDtoById(id);
		List<RepairReply> reply = new LinkedList<RepairReply>();
		reply = repairService.queryReplyByRepairId(id);

		model.addAttribute("repair", repairDto);
		model.addAttribute("reply", reply);
		return View.RepairDetailView;
	}

	/**
	 * 报修回复
	 * 
	 * @param replyId
	 *            回复的主题id
	 * @param replyContent
	 *            回复内容
	 * @param handle
	 *            handled已处理完成 unhandled不能处理
	 * @return
	 */
	@RequestMapping(value = Url.REPAIR_REPLY, method = RequestMethod.POST)
	public String reply(int replyId, String replyContent, String handle) {
		Repair repair = new Repair();
		if (handle == "handled" || "handled".equals(handle)) {
			// 更新为已处理完成 status=10
			repair.setId(replyId);
			repair.setStatus("10");
			repairService.updateRepairStatusById(repair);
		} else {
			// 阅读等级+1
			repairService.increaseReadlevel(replyId);
		}

		// 添加回复
		RepairReply reply = new RepairReply();
		reply.setContent(replyContent);
		reply.setCreateDate(new Date());
		reply.setRepairId(replyId);
		reply.setUserId(1);
		repairService.addRepairReply(reply);
		return "redirect:" + REPAIR_DETAIL_URL + replyId;
	}

	/**
	 * 新增报修 获得坐标
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.REPAIR_ADD_LOCATION)
	public String add(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("id").toString());
		User user = userService.queryUserById(userId);
		Community community = new Community();
		community = communityService.queryCommunityById(Integer.parseInt(user.getCommunityId()));

		model.addAttribute("community", community);
		return View.AddLocationView;
	}

	/**
	 * 新增报修 获得坐标
	 * 
	 * @param lng
	 * @param lat
	 * @return
	 */
	@RequestMapping(value = Url.REPAIR_ADD)
	public String addLocation(@PathVariable String lng, @PathVariable String lat, ModelMap model) {
		model.addAttribute("lng", lng);
		model.addAttribute("lat", lat);
		return View.AddRepairView;
	}

	/**
	 * 新增报修提交
	 * 
	 * @param title
	 * @param lng
	 * @param lat
	 * @param content
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = Url.REPAIR_ADD_SUBMIT, method = RequestMethod.POST)
	public String addRepair(String title, String lng, String lat, String content, HttpServletRequest request) throws IllegalStateException, IOException {
		String path = Utils.uploadFile(request);

		RepairPic repairPic = new RepairPic();
		repairPic.setPath(path);
		int picId = repairService.addRepairPic(repairPic);

		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("id").toString());
		User user = userService.queryUserById(userId);
		Repair repair = new Repair();
		repair.setTitle(title);
		repair.setContent(content);
		repair.setLongitude(lng);
		repair.setLatitude(lat);
		repair.setCreateDate(new Date());
		repair.setStatus("1");
		repair.setCreator(userId);
		repair.setPicId(picId);
		repair.setCommunityId(Integer.parseInt(user.getCommunityId()));
		repair.setReadLevel(0);
		repairService.addRepair(repair);

		return "redirect:" + REPAIR_UNHANDLED_URL;
	}
}

