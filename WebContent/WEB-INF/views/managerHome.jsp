<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>资产管理系统</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>
		欢迎<br>管理员
		<c:if
			test="${not empty sessionScope.manager && not empty sessionScope.manager.id }">
			<c:out value=":${manager.userName}" />
			<br />
		</c:if>
	</h1>
	<c:choose>
		<c:when
			test="${not empty sessionScope.manager && not empty sessionScope.manager.id }">
			<a href="<c:url value="/admin/manageManagers" />">管理管理员</a>|
			<a href="<c:url value="/admin/asset/register" />">资产录入</a>|
			<a href="<c:url value="/admin/managerCheckUselogs" />">审核申请</a>|
			<a href="<c:url value="/admin/managerDisplayAssets" />">查看资产领用状况和归还资产</a>| 
    		<a href="<c:url value="/admin/managerDisplayUsers" />">查看用户</a>|
    		<a href="<c:url value="/admin/logout" />">注销</a>
		</c:when>
		<c:otherwise>
			<a href="<c:url value="/admin/login" />">登录</a>
		</c:otherwise>
	</c:choose>
</body>
</html>

