<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/29/2026
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user =(User) session.getAttribute("user");
%>
<h1>
    <%=user.getName()%>
    <br>
    <%=user.getId()%>
</h1>

</body>
</html>
