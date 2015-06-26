package com.zhl.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhl.business.domain.UserResult;
import com.zhl.business.dto.UserDto;
import com.zhl.business.model.HeadPic;
import com.zhl.business.model.Role;
import com.zhl.business.model.User;

/**
 * 社区Dao
 * 
 * @author 张宏亮
 * 
 */
@Repository
public class UserDao extends BaseDao{
	private JdbcTemplate jdbcTemplate;
	private static final String FIND_USER_SQL = "select u.user_name as username, u.password, r.name, u.enable from user u, role r, user_role us "
			+ "where u.id = us.user_id and r.id = us.role_id and u.user_name = ? ";

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserResult findByName(String username) {
		final UserResult userResult = new UserResult();
		jdbcTemplate.query(FIND_USER_SQL, new Object[] { username }, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				userResult.setUsername(rs.getString("username"));
				userResult.setPassword(rs.getString("password"));
				userResult.setEnable(rs.getBoolean("enable"));
				userResult.addPower(rs.getString("name"));
			}
		});
		return userResult;
	}

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void addUser(User user) {
		getSqlMapClientTemplate().insert("user.addUser", user);
	}

	/**
	 * 查询全部用户
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<UserDto> queryUserDto(int start, int maxResults) {
		return (List<UserDto>) getSqlMapClientTemplate().queryForList("user.queryUserDto", start, maxResults);
	}

	/**
	 * 查询用户数
	 * 
	 * @return
	 */
	public int queryCountOfUser() {
		return (Integer) getSqlMapClientTemplate().queryForObject("user.queryCountOfUser");
	}

	/**
	 * 根据id查询UserDto
	 * 
	 * @param id
	 * @return
	 */
	public UserDto queryUserDtoById(int id) {
		return (UserDto) getSqlMapClientTemplate().queryForObject("user.queryUserDtoById", id);
	}

	/**
	 * 根据id查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserById(int id) {
		return (User) getSqlMapClientTemplate().queryForObject("user.queryUserById", id);
	}

	/**
	 * 编辑人员信息
	 * 
	 * @param user
	 */
	public void editUserById(User user) {
		getSqlMapClientTemplate().update("user.editUserById", user);
	}

	/**
	 * 添加头像图片
	 * 
	 * @param head
	 * @return id
	 */
	public int addHeadPic(HeadPic head) {
		return (Integer) getSqlMapClientTemplate().insert("user.addHeadPic", head);
	}

	/**
	 * 根据id查询头像
	 * 
	 * @param id
	 * @return path
	 */
	public String queryHeadPicById(int id) {
		return (String) getSqlMapClientTemplate().queryForObject("user.queryHeadPicById", id);
	}

	/**
	 * 删除用户权限对应关系
	 * 
	 * @param userId
	 */
	public void deleteUserRoleByUserId(int userId) {
		getSqlMapClientTemplate().delete("user.deleteUserRoleByUserId", userId);
	}

	/**
	 * 添加用户权限对应关系
	 * 
	 * @param map
	 *            (map包含两个int值：userId、roleId)
	 */
	public void addUserRole(Map map) {
		getSqlMapClientTemplate().insert("user.addUserRole", map);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void deleteUserById(int id) {
		getSqlMapClientTemplate().delete("user.deleteUserById", id);
	}

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return User
	 */
	public User queryUserByName(String userName) {
		return (User) getSqlMapClientTemplate().queryForObject("user.queryUserByName", userName);
	}

	/**
	 * 根据用户名查询用户List
	 * 
	 * @param userName
	 * @return List<User>
	 */
	public List<User> queryUserListByName(String userName) {
		return (List<User>) getSqlMapClientTemplate().queryForList("user.queryUserListByName", userName);
	}

	/**
	 * 根据用户id查用户权限
	 * 
	 * @param id
	 * @return Role
	 */
	public Role queryRoleByUserId(int id) {
		return (Role) getSqlMapClientTemplate().queryForObject("user.queryRoleByUserId", id);
	}

}
