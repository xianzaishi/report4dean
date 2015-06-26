<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/datepicker.css" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/datepicker.js"></script>
<!--中部-->
    <div class="center"> 
        <div class="center_a">
        
        <!--编辑用户-->
            <div class="bjyh">
                 <div class="bjyh_z">
                    <div class="bjyh_a_a">编辑用户</div>
                    <div class="bjyh_a_b"><a href="${contextPath}/user/index/page/1">返回上级</a></div>
                 </div>
                 <div class="clear"></div>
                 <form:form id="userForm" commandName="user" method="post">
                 <div class="bjyh_b">
                 	<a id="editHeadPic" href="javascript:void(0)" title="点击编辑头像"><img width="160px" height="160px" src="${contextPath}${imagePath }" alt="点击编辑头像" /></a> <!-- images/business/tu_3.gif -->
                 </div>
                 <div class="bjyh_c">
                     <div class="bjyh_e">
                            <ul>
                                <li>
                                    <div class="bjyh_e">用户名</div>
                                    <div ><form:input type="text" path="userName" class="bjyh_f" name="userName" id="userName"  value="" /></div>
                                 </li>
                                <li>
                                <div class="bjyh_e">姓名(真实姓名)</div>
                                <div ><form:input type="text" path="realName" class="bjyh_f" name='realName' id="realName"  value="" /></div>
                                 </li>
                                <li>
                                    <div class="bjyh_e">密码</div>
                                    <div ><form:input type="password" path="password" class="bjyh_f" name="password" id="password"  value="" /></div>
                                 </li>
                                <li>
                                    <div class="bjyh_e">身份证号</div>
                                    <div ><form:input type="text" path="personId" class="bjyh_f" name="personId" id="personId"  value="" /></div>
                                 </li>
                                <li>
                                    <div class="bjyh_e">邮箱</div>
                                    <div ><form:input type="text" path="email" class="bjyh_f" name="email" id="email"  value="" /></div>
                                 </li>
                                <li>
                                    <div class="bjyh_e">手机号</div>
                                    <div ><form:input type="text" path="mobile" class="bjyh_f" name="mobile" id="mobile"  value="" /></div>
                                 </li>
                                 <li>
                                    <div class="bjyh_e">性别</div>
                                    <div ><form:input type="text" path="sex" class="bjyh_f" name="sex" id="sex" value="" /></div>
                                 </li>
                                 <li>
                                    <div class="bjyh_e">出生日期</div>
                                    <div ><form:input type="text" path="birthday" class="bjyh_f" name="birthday" id="birthday"  value="" /></div>
                                 </li>
                                 <li>
                                    <div class="bjyh_e">所属小区</div>
                                    <div >
                                    	<select id="commSelect">
                                    		<c:forEach items="${commMap }" var="entry">
										  		<option value =${entry.key }>${entry.value }</option>
										  	</c:forEach>
										</select>
                                    	<form:hidden id="cmmId" path="communityId"></form:hidden>
                                    	<form:hidden id="userId" path="id"></form:hidden>
                                    	<form:hidden id="headPicId" path="headPicId"></form:hidden>
                                    </div>
                                 </li>
                            </ul>
                        </div>
                        
                 <div class="bjyh_g">
                     <div id="submitFrom" class="bjyh_g_a"><a href="javascript:void(0)">保存</a></div>
                     <div class="bjyh_g_b"><a href="${contextPath}/user/index/page/1">取消</a></div>
                 
                 </div>
                 </div>
                 </form:form>
            </div>
            
             <div class="clear"></div>   
            </div>
            
         <div class="clear"></div>   
        </div>
    </div>
<script type="text/javascript">
$(function(){
	$("#birthday").datepicker();
	
	//提交表单
	$("#submitFrom").click(function(){
		$("#cmmId").val($("#commSelect :selected").val());
		var  url = "${contextPath}/user/edit/submit";
		$("#userForm").attr("action", url);
		$("#userForm").submit();
	});
	
	//换头像
	$("#editHeadPic").click(function(){
		var url = "${contextPath }/user/upload/headpic/user/id/" + $("#userId").val();
		window.location.href = url;
	});
});
</script>