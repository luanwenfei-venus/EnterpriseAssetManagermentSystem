<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>资产股那里系统</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<a href="<c:url value="/admin" />">返回首页</a>
	<div class="uselogList">
		<h1>申请列表</h1>
		<ul class="uselogList">
			<c:forEach items="${paginationSupport.items}" var="uselog">
				<li id="uselog_<c:out value="${uselog.id}"/>">
					<div class="uselogMessage">
						<c:out value="${uselog.deviceId}" />
					</div>
					<div class="uselogTime">
						<fmt:formatDate value="${uselog.useday}"
							pattern="yyyy-MM-dd HH:mm:ss" />
						by
						<c:out value="${uselog.userName }" />
						<div style="text-align: right;">
							<c:choose>
								<c:when test="${uselog.checked == 0}">
									<a href="<c:url value="/admin/managerCheckUselogs/${uselog.id}" />">审核通过</a>
							&nbsp;&nbsp;|&nbsp;&nbsp;
							<a
										href="<c:url value="/admin/managerCheckUselogs/delete/${uselog.id}" />">删除</a>
								</c:when>
								<c:when test="${uselog.checked == 1}">
								This uselog had been checked.
								</c:when>
							</c:choose>
						</div>
						<hr>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	每页${paginationSupport.pageSize}条申请，
	第${paginationSupport.currentPageNo}/${paginationSupport.totalPageCount}页,共${paginationSupport.totalCount}条申请
	<c:if test="${paginationSupport.previousPage}">
		<a
			href="<c:url value="/uselogs?pageNo=${paginationSupport.currentPageNo-1}" />">上一页</a>
	</c:if>
	<c:if test="${paginationSupport.nextPage}">
		<a
			href="<c:url value="/uselogs?pageNo=${paginationSupport.currentPageNo+1}" />">下一页</a>
	</c:if>
</body>
</html>
