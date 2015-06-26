<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>赤峰微商</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<script src="http://api.map.baidu.com/api?v=1.5&ak=piUetduG3GHlRRRyfaE0CNjm" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
<script language="javascript" type="text/javascript" src="${contextPath}/script/json.js"></script>
<style type="text/css">  
#container{height:100%; width:100%;}
</style> 
</head>
<body>
<div class="xxy_c" style="height:511px;"><div style="width:100%;" align="right"><a id="next" href="javascript:void(0)">下一步</a></div><div id="container"></div></div>
<script type="text/javascript">
var endLng = ${community.longitude };
var endLat = ${community.latitude };

//下一步
$("#next").click(function(){
	var url = "${contextPath }/repair/add/lng/" + endLng + "/lat/" + endLat + "/get";
	window.location.href = url;
});

$(function(){
	var comLongitude = ${community.longitude };
	var comLatitude = ${community.latitude };
	var map = new BMap.Map("container",{mapType: BMAP_HYBRID_MAP});	// 创建地图实例
	map.disableDragging();	//禁止地图拖拽
	map.disableDoubleClickZoom();	//禁用双击放大
	var comPoint = new BMap.Point(comLongitude, comLatitude);  // 创建点坐标
	map.centerAndZoom(comPoint, 18);                 // 初始化地图，设置中心点坐标和地图级别
	var marker = new BMap.Marker(comPoint);        // 创建标注    
	marker.enableDragging(); 	//可拖拽的标注
	map.addOverlay(marker);                     // 将标注添加到地图中
	
	var opts = {    
		width : 180,     // 信息窗口宽度    
		height: 50,     // 信息窗口高度    
		title : "拖拽红点标注报修位置"  // 信息窗口标题   
	}
	var infoPoint = new BMap.Point(comLongitude - 0.000004, comLatitude + 0.000090);  // 创建点坐标
	var infoWindow = new BMap.InfoWindow("", opts);  // 创建信息窗口对象    
	map.openInfoWindow(infoWindow, infoPoint);      // 打开信息窗口
	
	//拖拽后标注的坐标
	marker.addEventListener("dragend", function(e){
		endLng = e.point.lng;
		endLat = e.point.lat;
	})
});
</script>
</body>
</html>