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
		欢迎
		<c:if
			test="${not empty sessionScope.user && not empty sessionScope.user.id }">
    	，<c:out value="${user.userName}" />
			<br />
		</c:if>
	</h1>
	<c:choose>
		<c:when
			test="${not empty sessionScope.user && not empty sessionScope.user.id }">
			<a href="<c:url value="/logout" />">注销</a>
		</c:when>
		<c:otherwise>
			<a href="<c:url value="/login" />">登录</a> |
    		<a href="<c:url value="/user/register" />">注册</a> | 
    		<a href="<c:url value="/admin" />">管理员入口</a>
		</c:otherwise>
	</c:choose>
</body>
</html>

