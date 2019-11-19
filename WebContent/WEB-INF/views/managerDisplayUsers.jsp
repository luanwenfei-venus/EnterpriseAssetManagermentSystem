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
	<div class="userList">
		<h1>用户列表</h1>
		<ul class="userList">
			<c:forEach items="${paginationSupport.items}" var="user">
				<li id="user_<c:out value="${user.id}"/>">
					<div class="users">
						<c:out value="id : ${user.id}" />
						&nbsp;&nbsp;
						<c:out value="username : ${user.userName}" />
						&nbsp;&nbsp;
						<c:out value="phone : ${user.phone}" />
						&nbsp;&nbsp;
						<c:out value="E-mail : ${user.email}" />
					</div>
					<div style="text-align: right;">
							<c:choose>
								<c:when test="${user.lock == 0}">
								<a href="<c:url value="/admin/managerDisplayUsers/lock/${user.id}" />">锁定</a>
								</c:when>
								<c:when test="${asset.lock == 1}">
								<a href="<c:url value="/admin/managerDisplayUsers/unlock/${user.id}" />">解锁</a>
								</c:when>
							</c:choose>
						<br/>
						<a
							href="<c:url value="/admin/managerDisplayUsers/delete/${user.id}" />">删除</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	每页${paginationSupport.pageSize}个用户，
	第${paginationSupport.currentPageNo}/${paginationSupport.totalPageCount}页,共${paginationSupport.totalCount}个用户
	<c:if test="${paginationSupport.previousPage}">
		<a
			href="<c:url value="/users?pageNo=${paginationSupport.currentPageNo-1}" />">上一页</a>
	</c:if>
	<c:if test="${paginationSupport.nextPage}">
		<a
			href="<c:url value="/users?pageNo=${paginationSupport.currentPageNo+1}" />">下一页</a>
	</c:if>
</body>
</html>
