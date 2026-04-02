<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/2/2026
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    User userObj = (User) session.getAttribute("User");
    int userId = userObj.getId();
%>
<body>
<form method = "post" action = "topic">
    <input type = "hidden" value="add" name="action">
    <label>Enter the topic name </label><br>
    <input type = "text" name = "topic-name">
    <input type="text" value ="<%=userId%>">
    <button>Submit</button>
</form>>
</body>
</html>
