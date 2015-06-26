package com.zhl.business.service;

import java.util.List;
import java.util.Map;

import com.zhl.business.dto.UserDto;
import com.zhl.business.model.HeadPic;
import com.zhl.business.model.Role;
import com.zhl.business.model.User;

public interface UserService {
	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 查询全部用户
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<UserDto> queryUserDto(int start, int maxResults);

	/**
	 * 查询用户数
	 * 
	 * @return
	 */
	public int queryCountOfUser();

	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 * @return
	 */
	public UserDto queryUserDtoById(int id);

	/**
	 * 根据id查询用户信息
	 * 
	 * @param id
	 * @return User
	 */
	public User queryUserById(int id);

	/**
	 * 编辑人员信息
	 * 
	 * @param user
	 */
	public void editUserById(User user);

	/**
	 * 添加头像图片
	 * 
	 * @param head
	 * @return id
	 */
	public int addHeadPic(HeadPic head);

	/**
	 * 根据id查询头像
	 * 
	 * @param id
	 * @return path
	 */
	public String queryHeadPicById(int id);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void deleteUserById(int id);

	/**
	 * 删除用户权限对应关系
	 * 
	 * @param userId
	 */
	public void deleteUserRoleByUserId(int userId);

	/**
	 * 添加用户权限对应关系
	 * 
	 * @param map
	 *            (map包含两个int值：userId、roleId)
	 */
	public void addUserRole(Map map);

	/**
	 * 授权
	 * 
	 * @param userId
	 * @param roleId
	 */
	public void authorize(int userId, int roleId);

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return User
	 */
	public User queryUserByName(String userName);

	/**
	 * 根据用户名查询用户List
	 * 
	 * @param userName
	 * @return List<User>
	 */
	public List<User> queryUserListByName(String userName);

	/**
	 * 根据用户id查用户权限
	 * 
	 * @param id
	 * @return Role
	 */
	public Role queryRoleByUserId(int id);
}
