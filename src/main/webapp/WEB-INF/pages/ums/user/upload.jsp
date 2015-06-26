<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传头像</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
<script language="javascript" type="text/javascript" src="${contextPath}/script/json.js"></script>

</head>
<body>
  <center><br/><br/><br/><br/><br/>
<form id="addForm" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td>文件：</td>
		<td>&nbsp;<input id="file" type="file" name="file" /><font size="2" color="red">&nbsp;*</font>
				<input id="userId" name="userId" type="hidden" value="${userId }"/>
		</td>
	</tr>
</table>
</form>
<br/><br/>
<div style="text-align:center">
	<a class="myButton" id="addButton" href="javascript:void(0)">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a class="myButton" id="canle" href="javascript:void(0)">取消</a>
</div>
</center>
</body>
<script type="text/javascript">
$(function(){
	//添加
	$("#addButton").click(function(){
		async = true;
		// 表单验证
		if($.trim($("#file").val()) == ""){
			alert("上传文件不能为空");
			return 0;
		}
		var url = "${contextPath }/user/head/pic/id/" + $("#userId").val();
		$("#addForm").attr("action", url);
		$("#addForm").submit();
	});
});
</script>
</html>