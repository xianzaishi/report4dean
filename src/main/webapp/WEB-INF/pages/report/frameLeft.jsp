<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>日报</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/business.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/dtree.css" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
<script language="javascript" type="text/javascript" src="${contextPath}/script/dtree.js"></script> 
</head>

<body>
<div id="tree" style="float: left; height: 400px; height: auto; min-height: 400px; margin-left: 20px; margin-top: 10px;">
   <div class="dtree">
	  <script type="text/javascript">
	  	var treeName = 'tree';
		var tree = new dTree(treeName,'${contextPath}');
	    tree.add(0,-1,'报表');
		//add(id, pid, name, url, title, target, icon, iconOpen, open) 
    	tree.add(1, 0, "院长日报", "${contextPath}/report/search/parm/1", "", "right");
    	tree.add(2, 0, "资源配置", "${contextPath}/report/search/parm/2", "", "right");
    	tree.add(3, 0, "工作负荷", "${contextPath}/report/search/parm/3", "", "right");
    	tree.add(4, 0, "治疗质量", "${contextPath}/report/search/parm/4", "", "right");
    	tree.add(5, 0, "工作效率", "${contextPath}/report/search/parm/5", "", "right");
    	tree.add(6, 0, "患者负担", "${contextPath}/report/search/parm/6", "", "right");
    	tree.add(7, 0, "资产运营", "${contextPath}/report/search/parm/7", "", "right");
    	tree.add(8, 0, "决策分析平台", "", "", "right");
    	tree.add(9, 8, "按抢救成功率分析", "${contextPath}/report/search/parm/9", "", "right");
    	tree.add(10, 8, "出院患者平均住院天数分析", "${contextPath}/report/search/parm/10", "", "right");
    	tree.add(11, 8, "平均病床工作日", "${contextPath}/report/search/parm/11", "", "right");
    	tree.add(12, 8, "病床周转次数", "${contextPath}/report/search/parm/12", "", "right");
    	tree.add(13, 8, "门诊诊断符合率", "${contextPath}/report/search/parm/13", "", "right");
    	tree.add(14, 8, "全院临床病理符合率", "${contextPath}/report/search/parm/14", "", "right");
    	tree.add(15, 8, "大型设备阳性率", "", "", "right");
    	tree.add(16, 8, "好转率", "", "", "right");
    	tree.add(17, 8, "治愈率", "", "", "right");
    	tree.add(18, 8, "死亡率", "", "", "right");
    	tree.add(19, 0, "在院病人分布", "${contextPath}/report/search/parm/19", "", "right");
		document.write(tree);
	 </script>
	</div>
</div>
</body>
</html>
