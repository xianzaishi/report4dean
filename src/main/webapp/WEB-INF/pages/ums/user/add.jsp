<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link href="${contextPath}/css/business.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery.validate.min.js"></script> 
<script language="javascript" type="text/javascript" src="${contextPath}/script/json.js"></script>

<style>
label.error{color:#ea5200; margin-left:0px; padding:0px 20px;  
background:url(images/unchecked.gif) no-repeat 2px 0 } 
label.right{margin-left:4px; padding-left:20px; background: 
url(images/checked.gif) no-repeat 2px 0} 
</style>
</head>

<body>
  
<!--用户注册-->
    <div class="zc">
        <div class="zc_a"><a href="${contextPath}/user/index/page/1">回到首页</a></div>
		<form:form id="userForm" commandName="user" method="post">
        <div class="zc_b">
           <div class="zc_c">现在注册</div>
           <div class="zc_d">请您核对个人信息，以便完成注册。如果您已有账号，点击这里登陆。</div>
              <div  class="zc_g">
                   <div class="zc_e">        
                       <ul>
                            <li>
                                <div class="zc_e">用户名</div>
                                <div ><form:input type="text" path="userName" class="zc_f" name='userName' id='userName'  value="" /></div>
                             </li>
                            <li>
                                <div class="zc_e">密码</div>
                                <div ><form:input type="password" path="password" class="zc_f" name='password' id='password'  value="" /></div>
                             </li>
                            <li>
	                            <div class="zc_e">姓名(真实姓名)</div>
	                            <div ><form:input type="text" path="realName" class="zc_f" name='realName' id='realName'  value="" /></div>
                            </li>
                            <li>
                                <div class="zc_e">身份证号</div>
                                <div ><form:input type="text" path="personId" class="zc_f" name='name' id='name'  value="" /></div>
                             </li>
                            <li>
                                <div class="zc_e">手机号</div>
                                <div ><form:input type="text" path="mobile" class="zc_f" name='name' id='name'  value="" /></div>
                             </li>
                            <li>
                                <div class="zc_e">邮箱</div>
                                <div ><form:input type="text" path="email" class="zc_f" name='email' id='email' value="" /></div>
                             </li>
                        </ul>
                   </div>  
              </div>
              <font color="red"><c:out value="${tip }" ></c:out></font>
           <div class="zc_j"><a id="submit" href="###">注册</a></div>
        </div>
		</form:form>
     </div>
</body>
<script type="text/javascript">
$(function(){
	$("#userForm").validate({
		rules: {
			userName: {
				required: true,
				minlength: 2
			},
			password: {
				required: true,
				minlength: 5
			}
		},
		messages: {
			userName: {
				required: "请输入用户名",
				minlength: "长度不能小于2个字符"
			},
			password: {
				required: "请输入密码",
				minlength: "长度不能小于5个字符"
			}
		}
	});
	
	$('#submit').click(function(){
		var url = "${contextPath }/user/add/submit";
		$('#userForm').attr("action", url);
		$('#userForm').submit();
	});
});
</script>
</html>