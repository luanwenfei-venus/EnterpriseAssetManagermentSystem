<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
  <head>
    <title>企业资产管理系统</title>
  </head>
  <body>
    <h1>欢迎来到吐槽吧
     <c:if test = "${not empty sessionScope.spitter && not empty sessionScope.spitter.id }">
    	，<c:out value="${spitter.lastName}" /> <c:out value="${spitter.firstName}" /><br/>
    </c:if>
    </h1>
  </body>
</html>
