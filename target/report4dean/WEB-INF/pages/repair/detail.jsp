<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style type="text/css">  
#container{height:100%; width:100%;}
</style> 
<div class="center"> 
    <div class="center_a">
        <!--详细页标题-->
        <div class="xxy">
            <div class="xxy_a">
                <div class="xxy_a_a"><img src="${contextPath}/images/business/biao_1.gif" /></div>
                <div class="xxy_a_b"><c:out value="${repair.title }"/></div>
                <div class="xxy_time"><fmt:formatDate  value="${repair.createDate }" pattern="yyyy.MM.dd" />&nbsp;&nbsp;<a href="${contextPath }/repair/index/page/1">返回</a></div>
            </div>   
        <!--详细页内容-->
            <div class="xxy_b"><c:out value="${repair.content }"/></div>
            <div class="xxy_c" style="height:511px;"><div id="container"></div></div>
            <div class="xxy_c"><a href="${contextPath}/${repair.pic }" title="点击图片查看大图" target="_blank"><img src="${contextPath}/${repair.pic }" alt="实拍照片" height="260px" width="770px"/></a></div>
            <div class="xxy_d"></div>
        <!--回复-->
        <c:if test="${repair.status != 10}">
        	<form id="replyForm" action="${contextPath }/repair/reply" method="post">
	            <div>
	            	<textarea id="replyContent" name="replyContent" rows="4" cols="90" style="margin-left: 25px;" onfocus="if (value =='在此回复'){value =''}" onblur="if (value ==''){value='在此回复'}">在此回复</textarea>
	            	<input id="replyId" name="replyId" type="hidden" value="${repair.id }" /><br/>
	            	<div style="text-align :center">
		            	<input type="radio" name="handle" value="handled" checked/>已处理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		            	<input type="radio" name="handle" value="unhandled" />不能处理 报上级处理
		            </div>
            	</div>
	            <div class="xxy_f"><a id="replyButton" href="javascript:void(0)">回复</a></div>
            </form>
		</c:if>
        <!--回复列表-->
        <c:forEach items="${reply }" var="replyList" varStatus="stat">
        <div class="hf">
            <div class="hf_a">
                <div class="hf_a_a">&nbsp;</div>
                <div class="hf_a_b"><img src="${contextPath}/images/business/tu_2.gif" /></div>
                <div class="hf_a_a">Yujianan</div>               
            </div>
            <div class="hf_c">
                 <div class="hf_c_a">${stat.index + 1}楼     <fmt:formatDate  value="${replyList.createDate }" pattern="yyyy.MM.dd hh:mm:ss" /></div>
                 <div class="hf_c_a"><c:out value="${replyList.content }"/></div>
                 <div class="hf_c_a"></div>
            </div>

        </div>
        </c:forEach>
        
        <div class="clear"></div>  
        </div>
                
        <!--右侧ads-->
        <div class="right_xz">
            <div class="center_left">
                <div class="center_left_a"><a href="###"><img src="${contextPath}/images/business/xz-pg.gif" /></a></div>
                <div class="center_left_a"><a href="###"><img src="${contextPath}/images/business/xz-az.gif" /></a></div>
            </div>
        </div>
        
        <div class="clear"></div>        
    </div>
</div>
<script type="text/javascript">
	$(function(){
		var comLongitude = ${repair.communityLongitude };
		var comLatitude = ${repair.communityLatitude };
		var longitude = ${repair.longitude };
		var latitude = ${repair.latitude };
		var map = new BMap.Map("container",{mapType: BMAP_HYBRID_MAP});	// 创建地图实例
		map.disableDragging();	//禁止地图拖拽
		map.disableDoubleClickZoom();	//禁用双击放大
		var comPoint = new BMap.Point(comLongitude, comLatitude);  // 创建点坐标
		map.centerAndZoom(comPoint, 18);                 // 初始化地图，设置中心点坐标和地图级别
		var repairPoint = new BMap.Point(longitude, latitude);	//创建保修点坐标
		var marker = new BMap.Marker(repairPoint);        // 创建标注
		map.addOverlay(marker);                     // 将标注添加到地图中
		
		
		//回复
		$("#replyButton").click(function(){
			$("#replyForm").submit();
		});
	});
</script>