<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>资产管理系统</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>添加管理员</h1>
	<sf:form method="POST" commandName="manager">
		<sf:errors path="*" cssClass="error" />
		<br />
		<br />
	用户名：<sf:input path="userName" />
		<sf:errors path="userName" cssClass="error" />
		<br />
		<br />
	     密码：<sf:password path="password" />
		<sf:errors path="password" cssClass="error" />
		<br />
		<br />
		<input type="submit" value="注册" />
	</sf:form>
</body>
</html>

