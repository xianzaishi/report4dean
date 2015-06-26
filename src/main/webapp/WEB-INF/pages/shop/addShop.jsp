<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script src="http://api.map.baidu.com/api?v=1.5&ak=piUetduG3GHlRRRyfaE0CNjm" type="text/javascript"></script>
<style type="text/css">  
#container{height:100%; width:100%;}
</style> 
<!--手机登录-->
<table>
<tr>
	<td>
		<div class="sj_dl" style="height: 420px; float: left; margin: 50px 0px 50px 100px;">
		  <div class="sj_dl_a">
		  <form id="shopForm" method="post" enctype="multipart/form-data">
		      <ul>
		      
		        <li>
		          <div class="sj_dl_aa">商铺名称</div>
		          <div class="sj_dl_ad" ><input type="text" class="sj_dl_ab" name='name' id='name' /><span class="sj_dl_ac">*</span></div>
		        </li>
		        
		        <li>
		          <div class="sj_dl_aa">所属小区</div>
		          <div class="sj_dl_ad" >
		          	<select id="commSelect">
		          		<option value="0">---------</option>
		          		<c:forEach items="${commMap }" var="entry">
					  		<option value =${entry.key }>${entry.value }</option>
					  	</c:forEach>
		          	</select>
					<span class="sj_dl_ac">*</span>
				  </div>
		        </li>
		        
		        <li>
		          <div class="sj_dl_aa">商铺地址</div>
		          <div class="sj_dl_ad" ><a id="chooseAddress" href="javascript:void(0)">选择地址</a><span class="sj_dl_ac">*</span></div>
		        </li>
		        
		       <li>
		          <div class="sj_dl_aa">联系人姓名</div>
		          <div class="sj_dl_ad" ><input type="text" class="sj_dl_ab" name='contacts' id='contacts' /><span class="sj_dl_ac">*</span></div>
		        </li>
		       
		        <li>
		          <div class="sj_dl_aa">手机号</div>
		          <div class="sj_dl_ad" >
		          	<input type="text" class="sj_dl_ab" name='mobile' id='mobile' />
		          	<input id="endLng" name="endLng" type="hidden">
		          	<input id="endLat" name="endLat" type="hidden">
		          	<input id="commId" name="commId" type="hidden">
		          	<span class="sj_dl_ac">*</span>
		          </div>
		        </li>
		        
		      </ul>        
		  </form>
		  </div>
		  
		      <div class="sj_qd_a">
		          <div class="sj_qd">
		              <a id="submit" href="javascript:void(0)"><div class="sj_text">确定</div></a>
		          </div>
		      </div>
		      <div class="clear"></div>
		  <div class="sj_dl_ah">需要完整填写所有带<span class="sj_dl_ac">*</span>全</div>
		
		</div>
	</td>
	<td>
		<div id="mapDiv" style="height: 420px; width:700px; float:right; margin: 50px 100px 50px 50px; display:none;"><div id="container"></div></div>
	</td>
</tr>
</table>
<br/><br/>
<script type="text/javascript">
var endLng = 0;
var endLat = 0;

//根据小区坐标初始化地图
function initMap(comLongitude, comLatitude){//comLongitude 小区经度	comLatitude 小区纬度
	var map = new BMap.Map("container",{mapType: BMAP_HYBRID_MAP});	// 创建地图实例
	map.disableDragging();	//禁止地图拖拽
	map.disableDoubleClickZoom();	//禁用双击放大
	var comPoint = new BMap.Point(comLongitude, comLatitude);  // 创建点坐标
	map.centerAndZoom(comPoint, 18);                 // 初始化地图，设置中心点坐标和地图级别
	var marker = new BMap.Marker(comPoint);        // 创建标注    
	marker.enableDragging(); 	//可拖拽的标注
	map.addOverlay(marker);                     // 将标注添加到地图中
	
	//拖拽后标注的坐标
	marker.addEventListener("dragend", function(e){
		endLng = e.point.lng;
		endLat = e.point.lat;
	});
}

$(function(){
	$("#chooseAddress").click(function(){
		//根据小区id获得小区坐标
		var commId = $("#commSelect :selected").val();
		$.ajax( {
			type:"GET",
			url : "${contextPath }/shop/cmm/location/get/" + commId + ".json",
			dataType : "json",
			timeout : 5000,
			async:false,
			success:function(data) {
				//初始化地图
				initMap(data.longitude, data.latitude);
				$("#mapDiv").show();
			},
			error : function(response) {
				alert("error");
			}
		});
	});
	
	//提交表单
	$("#submit").click(function(){
		if(endLng == 0){
			alert("请正确选择店铺位置！");
			return 0;
		}else{
			var name = $("#name").val();
			var contacts = $("#contacts").val();
			var mobile = $("#mobile").val();
			if(name=="" || contacts=="" || mobile==""){
				alert("请正确填写！");
				return 0;
			}
			$("#endLng").val(endLng);
			$("#endLat").val(endLat);
			$("#commId").val(commId);
			
			var url = "${contextPath }/shop/add/submit";
			$("#shopForm").attr("action", url);
			$("#shopForm").submit();
		}
	});
});
</script>