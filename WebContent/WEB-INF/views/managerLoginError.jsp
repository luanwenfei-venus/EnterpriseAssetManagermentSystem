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
	<h1>管理员登录有误，请重新尝试</h1>
	<a href="<c:url value="/admin/login" />">登录</a> |
	<a href="<c:url value="/admin" />">返回</a>
</body>
</html>
