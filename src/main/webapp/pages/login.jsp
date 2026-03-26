<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/22/2026
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String errorMsg = (String) request.getAttribute("error");
    if(errorMsg == null){
        errorMsg = "";
    }
%>
<form method = "post" action="login">
    <label>Email: </label>
    <input type="text" name="email">
    <label>Password</label>
    <input type="text" name="password">
    <button>Login</button>
</form>
</body>
</html>