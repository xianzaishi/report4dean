<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--中部-->
<div class="center"> 
    <div class="center_a">
    
    <!--用户管理-->
        <div class="yhgl">
            <div class="yhgl_z">
                   <div class="yhgl_a">用户管理</div>
                   <div class="yhgl_b"><a href="${contextPath}/user/add">新增用户</a></div>
                   <div class="yhgl_c">
                       <div ><input type="text"  class="yhgl_c_a" name='name' id='name' placeholder="请输入关键字" value="请输入关键字" /></div>
                       <div class="yhgl_c_b"><a href="###"><img src="${contextPath}/images/business/sou.gif" /></a></div>
                   </div> 
                   <div class="clear"></div> 
            </div>
            
            <div class="hygl_bg">
              <table width="976" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td valign="top" bgcolor="#dfdfdf">
                  <table width="976" height="88" border="0" align="center" cellpadding="0" cellspacing="1">
                    <tr>
                      <td width="188" height="39" bgcolor="#EEEEEE"><div align="center">用户名 </div></td>
                      <td width="168" height="39" bgcolor="#EEEEEE"><div align="center">姓名 </div></td>
                      <td width="202" height="39" bgcolor="#EEEEEE"><div align="center">所属小区 </div></td>
                      <td width="143" height="39" bgcolor="#EEEEEE"><div align="center">权限 </div></td>
                      <td width="273" height="39" bgcolor="#EEEEEE"><div align="center">操作</div></td>
                    </tr>
                    <c:forEach items="${userList }" var="userList">
                    <tr>
                      <td height="48" bgcolor="#FFFFFF"><div align="center"><c:out value="${userList.userName }"></c:out> </div></td>
                      <td height="48" bgcolor="#FFFFFF"><div align="center"><c:out value="${userList.realName }"></c:out> </div></td>
                      <td height="48" bgcolor="#FFFFFF"><div align="center"><c:out value="${userList.community }"></c:out></div></td>
                      <td height="48" bgcolor="#FFFFFF"><div align="center"><c:out value="${userList.modelName }"></c:out></div></td>
                      <td height="48" bgcolor="#FFFFFF">
                      	<div align="center">
	                      	<a href="${contextPath }/user/edit/id/${userList.id }">编辑</a> &nbsp;|&nbsp;&nbsp;
	                      	<a href="${contextPath }/user/delete/id/${userList.id }">删除</a> &nbsp;|&nbsp;&nbsp;
	                      	<a href="${contextPath }/user/authorize/user/id/${userList.id }">授权</a>
	                    </div>
	                  </td>
                    </tr>
                    </c:forEach>
                  </table></td>
                </tr>
              </table>
              <!--翻页-->
			<div class="list_fy">
				<div class="fenye">
					<span style="margin-left: 0px; margin-right: 0px;">
						<a id="toPrePage" href="javascript:void(0)" class="startorend"><</a>
						<a id="toNextPage" href="javascript:void(0)"  class="startorend">></a>
					</span>
					<span id="nowPage" style="margin-left: 0px; margin-right: 0px;"></span>
					<span style="margin-left: 0px; margin-right: 0px;">/</span>
					<span id="totalPage" style="margin-left: 0px; margin-right: 0px;"></span>
					<span style="margin-left: 0px; margin-right: 0px;">页</span>
					<span style="margin-left: 0px; margin-right: 0px;">跳转第<input type="text" size="3" />页</span>
					<a id="goToPage" href="javascript:void(0)" class="tiaozhuan">确定</a>
					<span style="margin-left: 0px; margin-right: 0px;">共</span>
					<span id="total" style="margin-left: 0px; margin-right: 0px;">10</span>
					<span style="margin-left: 0px; margin-right: 0px;">条记录</span>
				</div>
			</div>
			<!--翻页结束-->   
            </div>
         
         
         <div class="clear"></div>   
        </div>
        
     <div class="clear"></div>   
    </div>
</div>
<%@ include file="../../commons/utils/paging.jsp"%>