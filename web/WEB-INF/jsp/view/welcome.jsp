<%@ page import="java.util.Map" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.Calendar.Event" %>
<%@ page import="java.util.LinkedHashMap" %>

<%
    @SuppressWarnings("unchecked")
    Map<String, Event> eventDatabase =
            (Map<String, Event>)request.getAttribute("eventDatabase");

%>
<html>
<head>
    <title>User Homepages</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
</head>
<body>


<h1>Welcome <%=session.getAttribute("username")%></h1>
<br/>
<br/>

<%
    if(eventDatabase == null || eventDatabase.size() == 0)
    {
%><h3>Not subscribed to any events!</h3> <br/><p><em>Create one or follow one from the All Events page!</em><p></p><%
}
else
{
    for(Event name : eventDatabase.values())
    {
        String eventName = name.getEventName();
        String desc = name.getDescription();
        %>Event: <%= eventName %> <br/>


<br /><%
        }
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


</body>
</html>