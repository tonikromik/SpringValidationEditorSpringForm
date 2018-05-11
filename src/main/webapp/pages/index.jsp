<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
Hello on index page

<%--<form action="/save/user" method="post">--%>
    <%--<input type="" name="name" placeholder="name">--%>
    <%--<input type="submit" name="" placeholder="">--%>
<%--</form>--%>

<%--<form action="/save/car" method="post">--%>
    <%--<input type="" name="model" placeholder="model">--%>
    <%--<input type="submit" name="" placeholder="">--%>
<%--</form>--%>

<%--    у спрінга існує своя бібліотека для роботи з формами
        її обов'язково потрібно приєднати!!!

--%>

<sf:form action="/save/user" method="post" modelAttribute="userModel" >
    <sf:input path="name"/>
    <sf:errors path="name"/>
    <input type="submit">
</sf:form>

<sf:form action="/save/car" method="post" modelAttribute="carModel" >
    <sf:input path="model"/>
    <input type="submit">
</sf:form>


</body>
</html>
