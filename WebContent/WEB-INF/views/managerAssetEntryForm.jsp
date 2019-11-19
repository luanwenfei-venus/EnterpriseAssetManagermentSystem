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
	<a href="<c:url value="/admin" />">返回首页</a>
	<h1>添加资产</h1>
	<sf:form method="POST" commandName="asset">
		<sf:errors path="*" cssClass="error" />
		<br />
		<br />
		设备名称：
		<sf:input path="deviceName" />
		<sf:errors path="deviceName" cssClass="error" />
		<br />
		<br />
		品牌：<sf:input path="brand" />
		<sf:errors path="brand" cssClass="error" />
		<br />
		<br />
		型号：<sf:input path="deviceType" />
		<sf:errors path="deviceType" cssClass="error" />
		<br />
		<br />
		<input type="submit" value="添加" />
	</sf:form>
</body>
</html>

