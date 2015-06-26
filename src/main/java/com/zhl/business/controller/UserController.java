package com.zhl.business.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
import com.zhl.business.dto.UserDto;
import com.zhl.business.model.Community;
import com.zhl.business.model.HeadPic;
import com.zhl.business.model.Role;
import com.zhl.business.model.User;
import com.zhl.business.service.CommunityService;
import com.zhl.business.service.RoleService;
import com.zhl.business.service.UserService;
import com.zhl.business.util.UserUtil;
import com.zhl.business.util.Utils;

/**
 * User控制器
 * 
 * @author 张宏亮
 * 
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommunityService communityService;

	@Autowired
	private RoleService roleService;

	private final String USER_MANAGEMENT_INDEX_URL = "/user/index/page/1";

	private final String USER_EDIT_URL = "/user/edit/id/";

	/**
	 * 登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.LOGIN)
	public String login() {
		return View.LoginView;
	}

	/**
	 * 登陆后首页
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.SECOND)
	public String secondPage(HttpServletRequest request, ModelMap model) {
		int loginFlag = 1;
		UserUtil userUtil = new UserUtil();
		User user = new User();
		Role role = new Role();
		HttpSession session = request.getSession();
		if (userUtil.isLogin(request)) {
			user.setUserName(userUtil.getUserName(request));
			user = userService.queryUserByName(user.getUserName());
			role = userService.queryRoleByUserId(user.getId());

			session.setAttribute("userName", user.getUserName());
			session.setAttribute("id", user.getId());
			session.setAttribute("readLevel", role.getReadLevel());
		} else {
			loginFlag = -1;
		}

		model.addAttribute("loginFlag", loginFlag);
		return View.SecondView;
	}

	/**
	 * 用户管理首页
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.USER_INDEX)
	public String userIndex(@PathVariable int page, ModelMap model) {
		List<UserDto> userList = new LinkedList<UserDto>();
		userList = userService.queryUserDto((page - 1) * 8, 8);
		int count = userService.queryCountOfUser();

		model.addAttribute("userList", userList);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return View.UserIndexView;
	}

	/**
	 * 新增用户
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.ADD_USER)
	public String addUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return View.AddUserView;
	}

	/**
	 * 新增用户提交
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = Url.ADD_USER_SUBMIT)
	public String addUserSubmit(User user, ModelMap model) {
		if (!userService.queryUserListByName(user.getUserName()).isEmpty()) {
			model.addAttribute("tip", "用户名已经存在");
			return View.AddUserView;
		}

		user.setCreateDate(new Date());
		userService.addUser(user);
		return "redirect:" + USER_MANAGEMENT_INDEX_URL;
	}

	/**
	 * 编辑用户
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.EDIT_USER)
	public String editUser(@PathVariable int id, ModelMap model) {
		String imagePath = "";
		User user = new User();
		user = userService.queryUserById(id);

		List<Community> commList = new LinkedList<Community>();
		commList = communityService.queryCommunity();
		Map<Integer, String> commMap = new HashMap<Integer, String>();
		for (int i = 0; i < commList.size(); i++) {
			commMap.put(commList.get(i).getId(), commList.get(i).getName());
		}

		// 头像
		if (user.getHeadPicId() != 0) {
			imagePath = userService.queryHeadPicById(user.getHeadPicId());
		}

		model.addAttribute("user", user);
		model.addAttribute("commMap", commMap);
		model.addAttribute("imagePath", imagePath);
		return View.EditUserView;
	}

	/**
	 * 编辑用户提交
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = Url.EDIT_USER_SUBMIT, method = RequestMethod.POST)
	public String editUserSubmit(User user) {
		userService.editUserById(user);
		return "redirect:" + USER_MANAGEMENT_INDEX_URL;
	}

	/**
	 * 上传头像
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = Url.UPLOAD_USER_HEAD_PIC)
	public String uploadHeadPic(@PathVariable int id, ModelMap model) {
		model.addAttribute("userId", id);
		return View.UploadUserHeadPicView;
	}

	/**
	 * 上传头像提交
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = Url.UPLOAD_USER_HEAD_PIC_SUBMIT, method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest request, @PathVariable int id) throws IllegalStateException, IOException {
		String picPath = Utils.uploadFile(request);

		HeadPic head = new HeadPic();
		head.setPath(picPath);
		int headPicId = userService.addHeadPic(head);
		User user = new User();
		user.setId(id);
		user.setHeadPicId(headPicId);
		userService.editUserById(user);

		return "redirect:" + USER_EDIT_URL + id;
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = Url.DELETE_USER)
	public String deleteUser(@PathVariable int id) {
		// TODO service
		userService.deleteUserById(id);
		return "redirect:" + USER_MANAGEMENT_INDEX_URL;
	}

	/**
	 * 授权页面
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.AUTHORIZE)
	public String authorize(@PathVariable int id, ModelMap model) {
		List<Role> roleList = new LinkedList<Role>();
		roleList = roleService.queryRole();

		model.addAttribute("userId", id);
		model.addAttribute("roleList", roleList);
		return View.AuthorizeView;
	}

	/**
	 * 授权提交
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = Url.AUTHORIZE_SUBMIT)
	public String authorizeSubmit(@PathVariable int userId, @PathVariable int roleId) {
		userService.authorize(userId, roleId);
		return "redirect:" + USER_MANAGEMENT_INDEX_URL;
	}
}

