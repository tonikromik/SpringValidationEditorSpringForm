<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 11.05.2018
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>join</title>
</head>
<body>

<sf:form action="/save/car/user" method="post" modelAttribute="carModel">
    <sf:input path="model"/>
    <sf:select path="user">
        <c:forEach items="${users}" var="user">
            <sf:option value="${user.id}">
                ${user.name}
            </sf:option>
        </c:forEach>
    </sf:select>
    <input type="submit" name="" placeholder="">
</sf:form>

</body>
</html>
