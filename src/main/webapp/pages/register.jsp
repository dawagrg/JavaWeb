<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/19/2026
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Register Page</title>
</head>
<body>

<!-- Page Heading -->
Register Page

<%
    // Retrieve the error message from the request (set by servlet)
    String error = (String) request.getAttribute("error");

    // If no error message, initialize as empty string to avoid displaying "null"
    if(error == null ){
        error = "";
    }
%>

<!-- Display error message in red -->
<p class="col-first" style="color: red">
    <%= error %>
</p>

<!-- Registration Form -->
<form method="post" action="register">

    <!-- Full Name Input Field -->
    <div class="input-fields">
        <label>Full Name</label>
        <input type="text" name="fullname">
    </div>

    <!-- Email Input Field -->
    <div class="input-fields">
        <label>Email</label>
        <input type="email" name="email">
    </div>

    <!-- Password Input Field -->
    <div class="input-fields">
        <label>Password</label>
        <input type="text" name="password" required>
    </div>

    <!-- Submit Button -->
    <button type="submit">Submit</button>

</form>

</body>
</html>