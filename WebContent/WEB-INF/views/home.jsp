<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
  <head>
    <title>吐槽吧</title>
    <link rel="stylesheet" 
          type="text/css" 
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <h1>欢迎来到吐槽吧
     <c:if test = "${not empty sessionScope.spitter && not empty sessionScope.spitter.id }">
    	，<c:out value="${spitter.lastName}" /> <c:out value="${spitter.firstName}" /><br/>
    </c:if>
    </h1>
    <c:choose>
    	<c:when test = "${not empty sessionScope.spitter && not empty sessionScope.spitter.id }">
    		<a href="<c:url value="/spittles" />">吐个槽</a> |
    		<a href="<c:url value="/logout" />">注销</a> 
    	</c:when>
    	<c:otherwise>
    		<a href="<c:url value="/login" />">登录</a> |
    		<a href="<c:url value="/spitter/register" />">注册</a> |
    		<a href="<c:url value="/managerLogin" />">管理员</a> 
    	</c:otherwise>
    </c:choose>
    
    
  </body>
</html>
