package com.zhl.business.constant;

public class Url {
	/**
	 * 首页
	 */
	public static final String INDEX = "/index";
	
	/**
	 * 登陆后首页
	 */
	public static final String SECOND = "/second";

	/*--------------------------------- 用户模块 开始 --------------------------------------*/
	public static final String USER_BASE = "/user";

	/**
	 * 登陆
	 */
	public static final String LOGIN = "/ums/login";

	/**
	 * 用户管理首页
	 */
	public static final String USER_INDEX = USER_BASE + "/index/page/{page}";

	/**
	 * 新增用户
	 */
	public static final String ADD_USER = USER_BASE + "/add";

	/**
	 * 新增用户提交
	 */
	public static final String ADD_USER_SUBMIT = USER_BASE + "/add/submit";

	/**
	 * 编辑用户
	 */
	public static final String EDIT_USER = USER_BASE + "/edit/id/{id}";

	/**
	 * 编辑用户提交
	 */
	public static final String EDIT_USER_SUBMIT = USER_BASE + "/edit/submit";

	/**
	 * 上传头像
	 */
	public static final String UPLOAD_USER_HEAD_PIC = USER_BASE + "/upload/headpic/user/id/{id}";

	/**
	 * 上传头像提交
	 */
	public static final String UPLOAD_USER_HEAD_PIC_SUBMIT = USER_BASE + "/head/pic/id/{id}";

	/**
	 * 删除用户
	 */
	public static final String DELETE_USER = USER_BASE + "/delete/id/{id}";

	/**
	 * 授权页面
	 */
	public static final String AUTHORIZE = USER_BASE + "/authorize/user/id/{id}";

	/**
	 * 授权提交
	 */
	public static final String AUTHORIZE_SUBMIT = USER_BASE + "/authorize/user/{userId}/role/{roleId}";

	/*--------------------------------- 用户模块 结束 --------------------------------------*/

	/*--------------------------------- 设备报修模块 开始 --------------------------------------*/
	public static final String REPAIR_BASE = "/repair";

	/**
	 * 新增获得坐标
	 */
	public static final String REPAIR_ADD_LOCATION = REPAIR_BASE + "/add";

	/**
	 * 新增报修
	 */
	public static final String REPAIR_ADD = REPAIR_BASE + "/add/lng/{lng}/lat/{lat}/get";

	/**
	 * 新增报修提交
	 */
	public static final String REPAIR_ADD_SUBMIT = REPAIR_BASE + "/add/submit";

	/**
	 * 首页(未处理)
	 */
	public static final String REPAIR_INDEX = REPAIR_BASE + "/index/page/{page}";

	/**
	 * 首页(已处理)
	 */
	public static final String REPAIR_HANDLED_INDEX = REPAIR_BASE + "/index/handled/page/{page}";

	/**
	 * 详细页面
	 */
	public static final String REPAIR_DETAIL = REPAIR_BASE + "/detail/id/{id}";

	/**
	 * 报修回复
	 */
	public static final String REPAIR_REPLY = REPAIR_BASE + "/reply";
	/*--------------------------------- 设备报修模块 结束 --------------------------------------*/
	/*----------------------------------- 商城模块 开始 ----------------------------------------*/
	public static final String SHOP_BASE = "/shop";

	/**
	 * 商城首页
	 */
	public static final String SHOP_INDEX = SHOP_BASE + "/index";

	/**
	 * 商城详细页面
	 */
	public static final String SHOP_DETAIL = SHOP_BASE + "/detail";

	/**
	 * 添加商铺页面
	 */
	public static final String SHOP_ADD = SHOP_BASE + "/add";

	/**
	 * 根据小区id获得坐标
	 */
	public static final String SHOP_CMM_LOCATION_GET = SHOP_BASE + "/cmm/location/get/{cmmId}";

	/**
	 * 添加商铺提交
	 */
	public static final String SHOP_ADD_SUBMIT = SHOP_BASE + "/shop/add/submit";
	/*----------------------------------- 商城模块 结束 ----------------------------------------*/

	/*----------------------------------- 报表模块 开始 ----------------------------------------*/
	/**
	 * 左页面
	 */
	public static final String REPORT_LEFT = "/report/left";

	/**
	 * 右页面
	 */
	public static final String REPORT_RIGHT = "/report/right";

	/**
	 * 显示查询中页面
	 */
	public static final String REPORT_SEARCHING = "/report/search/parm/{parm}";
	/*----------------------------------- 报表模块 结束 ----------------------------------------*/
}
