<%@ page import="java.util.Map" %>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.Calendar.Event" %>
<%
    @SuppressWarnings("unchecked")
    Map<String, Event> eventDatabase =
            (Map<String, Event>)request.getAttribute("eventDatabase");
%>
<html>
<head>
    <title>User Homepage</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
</head>
<body>

<h1>Welcome <%=session.getAttribute("username")%></h1>
<br/>
<br/>

<% if(eventDatabase.size() == 0)
    {%> <em>You are not subscribed to any events. Create one yourself or view all events!</em><%
}
else
{

}
%>

<br/>
<form action="event?action=create" method="POST">
    <input type="submit" value="Create Event"><br/>
</form>
<form action="home?action=logout" method="POST">
    <input type="submit" value="Log out"><br/>
    </form>

<form action="home" method="POST">
    <input type="submit" value="Event Page">
</form>
<br/>
<hr/>
</body>
</html>