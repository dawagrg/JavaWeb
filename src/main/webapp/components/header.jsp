<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Learning Log System</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background-color: #f4f4f4;
        }

        nav {
            background-color: #500073;
            display: flex;
            flex-direction: row;
            padding: 5px 20px;
            justify-content: space-between;
            align-items: center;
        }
        logo {
        /background-color: #2A004E;/
        color: white;
        /padding: 15px;/
        }

        .links > a {
            color: white;
            margin-right: 15px;
            text-decoration: none;
            font-weight: bold;
        }

        nav a:hover {
            color: #F14A00;
        }

        .container {
            padding: 20px;
        }
    </style>
</head>

<body>
<nav>
    <logo>
        <h2>Learning Log Dashboard</h2>
    </logo>
    <div class="links">
        <a href="dashboard">Dashboard</a>
        <a href="topic">Add topic</a>
        <a href="topic?action=list">View Topics</a>
        <a href="logout">Logout</a>
    </div>
</nav>

<div class="container">