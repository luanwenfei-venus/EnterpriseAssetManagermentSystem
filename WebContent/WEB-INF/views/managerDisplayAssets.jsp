<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>资产管理系统</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<a href="<c:url value="/admin" />">返回首页</a>
	<div class="assetList">
		<h1>资产领用状态</h1>
		<ul class="assetList">
			<c:forEach items="${paginationSupport.items}" var="asset">
				<li id="asset_<c:out value="${asset.id}"/>">
					<div class="assetMessage">
						编号：
						<c:out value="${asset.id}" />  
						名称：
						<c:out value="${asset.deviceName}" />
						品牌：
						<c:out value="${asset.brand}" />
						型号：
						<c:out value="${asset.deviceType}" />
						采购时间：
						<fmt:formatDate value="${asset.day}" pattern="yyyy-MM-dd" />
						<div style="text-align: right;">
							<c:choose>
								<c:when test="${asset.status == 0}">
									空闲
								</c:when>
								<c:when test="${asset.status == 1}">
								已被领用<br/>
								<a href="<c:url value="/admin/managerDisplayAssets/${asset.id}" />">归还</a>
								</c:when>
							</c:choose>
						</div>
						<hr>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	每页${paginationSupport.pageSize}条，
	第${paginationSupport.currentPageNo}/${paginationSupport.totalPageCount}页,共${paginationSupport.totalCount}条
	<c:if test="${paginationSupport.previousPage}">
		<a
			href="<c:url value="/assets?pageNo=${paginationSupport.currentPageNo-1}" />">上一页</a>
	</c:if>
	<c:if test="${paginationSupport.nextPage}">
		<a
			href="<c:url value="/assets?pageNo=${paginationSupport.currentPageNo+1}" />">下一页</a>
	</c:if>
</body>
</html>
