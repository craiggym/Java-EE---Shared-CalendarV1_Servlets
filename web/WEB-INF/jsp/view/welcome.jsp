<%@ page import="java.util.Map" %>
<%@ page import="java.io.PrintWriter" %>
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
<h2>To view the Your Event Page click the button below</h2>
<form action="event?action=userEventView" method="POST">
    <input type="submit" value="Events you liked">

</form>
<h2>To view the created events click the button below</h2>
<form action="event?action=Created_view" method="POST">
    <input type="submit" value="Created Events">
</form>

</body>
</html>