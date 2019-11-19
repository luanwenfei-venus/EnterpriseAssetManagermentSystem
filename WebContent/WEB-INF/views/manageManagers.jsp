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
	<a href="<c:url value="/admin/manageManagers/register" />">添加管理员</a>
	<hr>
	<a href="<c:url value="/admin" />">返回首页</a>
	<div class="managerList">
		<h1>管理员列表</h1>
		<ul class="managerList">
			<c:forEach items="${paginationSupport.items}" var="manager">
				<li id="manager_<c:out value="${manager.id}"/>">
					<div class="managers">
						<c:out value="id : ${manager.id}" />
						&nbsp;&nbsp;
						<c:out value="username : ${manager.userName}" />
						<div style="text-align: right;">
							<a href="<c:url value="/admin/manageManagers/${manager.id}" />">删除</a>
						</div>
						<hr>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	每页${paginationSupport.pageSize}管理者，
	第${paginationSupport.currentPageNo}/${paginationSupport.totalPageCount}页,共${paginationSupport.totalCount}管理者
	<c:if test="${paginationSupport.previousPage}">
		<a
			href="<c:url value="/managers?pageNo=${paginationSupport.currentPageNo-1}" />">上一页</a>
	</c:if>
	<c:if test="${paginationSupport.nextPage}">
		<a
			href="<c:url value="/managers?pageNo=${paginationSupport.currentPageNo+1}" />">下一页</a>
	</c:if>
</body>
</html>
