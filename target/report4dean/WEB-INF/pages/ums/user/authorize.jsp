<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色授权</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/myButton.css" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
</head>
<body><br/><br/>
<div style="text-align: left; margin-left: 100px; margin-right: 100px;">
	<c:forEach items="${roleList }" var="roleList">
		<input name="roleName" type="radio" value="${roleList.id }"/><c:out value="${roleList.modelName }" /><br/>
	</c:forEach>
	<input id="userId" type="hidden" value="${userId }"/>
</div>
<br/>
<div style="text-align:center">
	<a class="myButton" id="submit" href="javascript:void(0)">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>
<script language="javascript">
$(function(){
	$("#submit").click(function(){
		var roleId = $("input[name='roleName']:checked").val();
		var userId = $("#userId").val();
		var url = "${contextPath}/user/authorize/user/" + userId + "/role/" + roleId;
		if(roleId == undefined || roleId == null){
			alert("请选择权限后提交");
		}else{
			window.location.href = url;
		}
	});
});
</script>
</body>
</html>