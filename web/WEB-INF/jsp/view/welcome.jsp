<%@ page import="java.util.Map" %>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Homepage</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
</head>
<body>

<h1>Welcome <%=session.getAttribute("username")%></h1>
<br/>
<br/>
<form action="event?action=create" method="POST">
    <input type="submit" value="Create Event"><br/>
</form>
<form action="event?action=logout" method="POST">
    <input type="submit" value="Log out"><br/>
    </form>

<form action="home" method="POST">
    <input type="submit" value="Event Page">
</form>
<br/>
<hr/>
</body>
</html>