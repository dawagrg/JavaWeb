<%@ page import="com.learninglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/2/2026
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    User userObj = (User) session.getAttribute("user");
    int userId=0;
    if(userObj != null){     userId= userObj.getId();}
%>
<body>
<form method="post" action="topic">
    <input type="hidden" value="add" name="action">
    <BR>
    <label>Enter the topic name</label><br>
    <input type="text" name="topic-name">
    <label>User Id</label>
    <input type="text" value="<%=userId%>" name="userid" disabled>
    <button>Submit</button>

</form>
</body>
</html>