package com.zhl.business.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhl.business.dao.UserDao;
import com.zhl.business.dto.UserDto;
import com.zhl.business.model.HeadPic;
import com.zhl.business.model.Role;
import com.zhl.business.model.User;
import com.zhl.business.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		userDao.addUser(user);
	}

	/**
	 * 查询全部用户
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<UserDto> queryUserDto(int start, int maxResults) {
		return userDao.queryUserDto(start, maxResults);
	}

	/**
	 * 查询用户数
	 * 
	 * @return
	 */
	public int queryCountOfUser() {
		return userDao.queryCountOfUser();
	}

	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 * @return
	 */
	public UserDto queryUserDtoById(int id) {
		return userDao.queryUserDtoById(id);
	}

	/**
	 * 根据id查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserById(int id) {
		return userDao.queryUserById(id);
	}

	/**
	 * 编辑人员信息
	 * 
	 * @param user
	 */
	public void editUserById(User user) {
		userDao.editUserById(user);
	}

	/**
	 * 添加头像图片
	 * 
	 * @param head
	 * @return id
	 */
	public int addHeadPic(HeadPic head) {
		return userDao.addHeadPic(head);
	}

	/**
	 * 根据id查询头像
	 * 
	 * @param id
	 * @return path
	 */
	public String queryHeadPicById(int id) {
		return userDao.queryHeadPicById(id);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteUserById(int id) {
		// TODO 删除用户上传头像
		// 删除用户权限对应关系
		userDao.deleteUserRoleByUserId(id);
		// 删除用户
		userDao.deleteUserById(id);
	}

	/**
	 * 删除用户权限对应关系
	 * 
	 * @param userId
	 */
	public void deleteUserRoleByUserId(int userId) {
		userDao.deleteUserRoleByUserId(userId);
	}

	/**
	 * 添加用户权限对应关系
	 * 
	 * @param map
	 *            (map包含两个int值：userId、roleId)
	 */
	public void addUserRole(Map map) {
		userDao.addUserRole(map);
	}

	/**
	 * 授权
	 * 
	 * @param userId
	 * @param roleId
	 */
	@Transactional(rollbackFor = Exception.class)
	public void authorize(int userId, int roleId) {
		// 删除用户权限对应关系
		userDao.deleteUserRoleByUserId(userId);
		// 添加用户权限对应关系
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", userId);
		map.put("roleId", roleId);
		userDao.addUserRole(map);
	}

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return User
	 */
	public User queryUserByName(String userName) {
		return userDao.queryUserByName(userName);
	}

	/**
	 * 根据用户名查询用户List
	 * 
	 * @param userName
	 * @return List<User>
	 */
	public List<User> queryUserListByName(String userName) {
		return userDao.queryUserListByName(userName);
	}

	/**
	 * 根据用户id查用户权限
	 * 
	 * @param id
	 * @return Role
	 */
	public Role queryRoleByUserId(int id) {
		return userDao.queryRoleByUserId(id);
	}
}
