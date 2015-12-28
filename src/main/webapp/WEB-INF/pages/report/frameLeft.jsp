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
    	tree.add(1, 0, "院长日报", "${contextPath}/report/search/parm/1", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(2, 0, "资源配置", "${contextPath}/report/search/parm/2", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(3, 0, "工作负荷", "${contextPath}/report/search/parm/3", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(4, 0, "治疗质量", "${contextPath}/report/search/parm/4", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(5, 0, "工作效率", "${contextPath}/report/search/parm/5", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(6, 0, "患者负担", "${contextPath}/report/search/parm/6", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(7, 0, "资产运营", "${contextPath}/report/search/parm/7", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(8, 0, "医疗质量分析", "", "", "right");
    	tree.add(9, 8, "按抢救成功率分析", "${contextPath}/report/search/parm/9", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(10, 8, "出院患者平均住院天数分析", "${contextPath}/report/search/parm/10", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(32, 8, "平均病床工作日", "", "", "right");
    	tree.add(11, 32, "平均病床工作日 按月", "${contextPath}/report/search/parm/11", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(33, 32, "平均病床工作日 按科室", "${contextPath}/report/search/parm/33", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(26, 8, "病床周转次数", "", "", "right");
    	tree.add(12, 26, "病床周转次数 按月", "${contextPath}/report/search/parm/12", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(27, 26, "病床周转次数 按科室", "${contextPath}/report/search/parm/27", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(13, 8, "门诊诊断符合率", "${contextPath}/report/search/parm/13", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(34, 8, "全院临床病理符合率", "", "", "right");
    	tree.add(14, 34, "全院临床病理符合率 按月", "${contextPath}/report/search/parm/14", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(28, 34, "全院临床病理符合率 按科室", "${contextPath}/report/search/parm/28", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(51, 8, "大型设备阳性率", "", "", "right");
    	tree.add(15, 51, "大型设备阳性率", "${contextPath}/report/search/parm/15", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(52, 51, "DR甲片率", "${contextPath}/report/search/parm/52", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(20, 8, "好转率", "", "", "right");
    	tree.add(16, 20, "好转率(按月)", "${contextPath}/report/search/parm/16", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(23, 20, "好转率(按科室)", "${contextPath}/report/search/parm/23", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(21, 8, "治愈率", "", "", "right");
    	tree.add(17, 21, "治愈率(按月)", "${contextPath}/report/search/parm/17", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(24, 21, "治愈率(按科室)", "${contextPath}/report/search/parm/24", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(22, 8, "死亡率", "", "", "right");
    	tree.add(18, 22, "死亡率(按月)", "${contextPath}/report/search/parm/18", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(25, 22, "死亡率(按科室)", "${contextPath}/report/search/parm/25", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(19, 0, "在院病人分布", "${contextPath}/report/search/parm/19", "", "right", "${contextPath}/images/unit-completed.jpg");
    	//tree.add(29, 8, "病床使用率分析", "", "", "right");
    	//tree.add(30, 29, "病床使用率分析 按月", "", "", "right", "${contextPath}/images/unit-completed.jpg");
    	//tree.add(31, 29, "病床使用率分析 按科室", "", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(35, 0, "手术明细表", "", "", "right", "");
    	tree.add(36, 35, "愈合 甲", "${contextPath}/report/search/parm/36", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(37, 35, "愈合 乙", "${contextPath}/report/search/parm/37", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(38, 35, "愈合 丙", "${contextPath}/report/search/parm/38", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(39, 35, "愈合 丁", "${contextPath}/report/search/parm/39", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(40, 0, "分科病人手术操作质量", "", "", "right", "");
    	tree.add(41, 40, "分科病人手术操作质量 全院", "${contextPath}/report/search/parm/41", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(42, 40, "分科病人手术操作质量 外科系统", "${contextPath}/report/search/parm/42", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(43, 40, "分科病人手术操作质量 内科系统", "${contextPath}/report/search/parm/43", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(44, 8, "入出院诊断符合率", "${contextPath}/report/search/parm/44", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(45, 8, "手术前后诊断符合率", "${contextPath}/report/search/parm/45", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(46, 8, "临床主要诊断与病理诊断符合率", "${contextPath}/report/search/parm/46", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(47, 8, "重点手术疗效及费用(ICD)18以上", "${contextPath}/report/search/parm/47", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(48, 8, "重点疾病疗效及费用(ICD)18以上", "", "", "right", "");
    	tree.add(49, 48, "重点疾病疗效及费用(ICD)18以上", "${contextPath}/report/search/parm/49", "", "right", "${contextPath}/images/unit-completed.jpg");
    	tree.add(50, 48, "卫生部", "${contextPath}/report/search/parm/50", "", "right", "${contextPath}/images/unit-completed.jpg");
		document.write(tree);//max 52
	 </script>
	</div>
</div>
</body>
</html>
