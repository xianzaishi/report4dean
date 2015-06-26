<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>赤峰微商—用户登录</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/business.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/business-1.css" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
</head>

<body>
<!--手机登录-->
    <div class="sj_dl" style=" height: 390px;">
    <form id="repairForm" method="post"  enctype="multipart/form-data">
      <div class="sj_dl_a">
          <ul>
          
            <li>
              <div class="sj_dl_aa">标题</div>
              <div class="sj_dl_ad" >
              	<input type="text" class="sj_dl_ab" name='title' id='title' />
              	<input type="hidden" value="${lng }"  name='lng' id='lng' />
              	<input type="hidden" value="${lat }"  name='lat' id='lat' />
              	<span class="sj_dl_ac">*</span>
			  </div>
            </li>
            
            <li>
              <div class="sj_dl_aa">详细描述</div>
              <div class="sj_dl_ad" >
              	<textarea rows="3" cols="20" name="content" id="content"></textarea>
              	<span class="sj_dl_ac">*</span>
              </div>
          	  <br/><br/><br/>
            </li>
            
            <li>
              <div class="sj_dl_aa">上传图片</div>
              <div class="sj_dl_ad" >
              	<input type="file" class="sj_dl_ab" name='file' id='file' />
              	<span class="sj_dl_ac">*</span>
			  </div>
            </li>
          </ul>
      
      </div>
      </form>
      
          <div class="sj_qd_a">
              <div class="sj_qd">
                  <div class="sj_text"><a id="submit" href="javascript:void(0)">确定</a></div>
              </div>
          </div>
          <div class="clear"></div>
      <div class="sj_dl_ah">需要完整填写所有带<span class="sj_dl_ac">*</span>的项目</div>
    
    </div>

</body>
<script type="text/javascript">
$(function(){
	$("#submit").click(function(){
		var url="${contextPath}/repair/add/submit";
		$("#repairForm").attr("action", url);
		$("#repairForm").submit();
	});
});
</script>
</html>
