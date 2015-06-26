<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!--中部-->
<div class="center"> 
    <div class="center_a">
        <!--未处理-->
        <div class="wcl">
            <div class="wcl_a">
                <div class="wcl_a_a"><a href="${contextPath }/repair/add">新增</a>&nbsp;</div>
                <div class="wcl_a_a"><a href="${contextPath }/repair/index/page/1">未处理</a></div>
                <div class="wcl_a_c">|</div>
                <div class="wcl_a_a"><a href="${contextPath }/repair/index/handled/page/1">已处理</a></div>
				<div class="wcl_a_b">
					<c:set var="flag" value="${flag }" />
					<c:choose>
					    <c:when test="${flag == 'handled'}">
					        <a href="${contextPath }/repair/index/handled/page/1">刷新列表</a>
					    </c:when>
					    <c:otherwise>
					    	<a href="${contextPath }/repair/index/page/1">刷新列表</a>
					    </c:otherwise>
					</c:choose>
				</div>
			</div>

            <div class="wcl_b_b">
              <ul>
              	<c:forEach items="${repairList }" var="repairList">
                	<li>
                		<a href="${contextPath }/repair/detail/id/${repairList.id }">
                			<c:set var="titleStr" value="${repairList.title }" />
							<c:choose>
							    <c:when test="${fn:length(titleStr) > 30}">
							        <c:out value="${fn:substring(titleStr, 0, 30)}......" />
							    </c:when>
							   <c:otherwise>
							      <c:out value="${titleStr}" />
							    </c:otherwise>
							</c:choose>
                		</a>
                		<span class="list_time"><fmt:formatDate  value="${repairList.createDate }" pattern="yyyy.MM.dd HH:mm:ss" /></span>
                	</li> 
                </c:forEach>
              </ul>
            </div>

			<!--翻页-->
			<div class="list_fy">
				<div class="fenye">
					<span style="margin-left: 0px; margin-right: 0px;">
						<a id="toPrePage" href="javascript:void(0)" class="startorend"><</a>
						<a id="toNextPage" href="javascript:void(0)"  class="startorend">></a>
					</span>
					<span id="nowPage" style="margin-left: 0px; margin-right: 0px;"></span>
					<span style="margin-left: 0px; margin-right: 0px;">/</span>
					<span id="totalPage" style="margin-left: 0px; margin-right: 0px;"></span>
					<span style="margin-left: 0px; margin-right: 0px;">页</span>
					<span style="margin-left: 0px; margin-right: 0px;">跳转第<input type="text" size="3" />页</span>
					<a id="goToPage" href="javascript:void(0)" class="tiaozhuan">确定</a>
					<span style="margin-left: 0px; margin-right: 0px;">共</span>
					<span id="total" style="margin-left: 0px; margin-right: 0px;">10</span>
					<span style="margin-left: 0px; margin-right: 0px;">条记录</span>
				</div>
			</div>
			<!--翻页结束-->   
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
<%@ include file="../commons/utils/paging.jsp"%>