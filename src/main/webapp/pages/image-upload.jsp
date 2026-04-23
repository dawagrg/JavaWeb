<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/23/2026
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/components/header.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="color: green">${success}</p>
<p style="color: red">${error}</p>
<p style="">${imagePath}</p>
<form method="post" action="image" enctype="multipart/form-data">
    Name:
    <input type="text" name="name" required>
    <br>
    <input type="file" name="image" required>
    <br>
    <button>Add</button>

</form>
</body>
</html>