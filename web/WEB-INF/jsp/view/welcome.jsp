<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Homepage</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
</head>
<body>
<h1>Welcome</h1>
<br/>
<br/>
<form action="loginsuccess?action=create" method="POST">
    <input type="submit" value="Create Event"><br/>
</form>
<form action="loginsuccess?action=logout" method="POST">
    <input type="submit" value="Log out"><br/>
    <br/>
    <hr/>
</form>
</body>
</html>