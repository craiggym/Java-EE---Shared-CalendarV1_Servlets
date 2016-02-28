<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.Calendar.Event" %>
<%
    @SuppressWarnings("unchecked")
    Map<String, Event> eventDatabase =
            (Map<String, Event>)request.getAttribute("ticketDatabase");
%>
<html>
<head>
    <title>User Homepage</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
</head>
<body>
<h1>Welcome</h1>
<br/>
<br/>
<% if(event.size() == 0)
    {%> <em>You are not subscribed to any events. Create one yourself or view all events!</em><%
}
else
{
    for(int id : event.keySet())
    {
        String idString = Integer.toString(id);
        Event e = event.get(id);
%>Events:\n #<%= idString %>: <a href="<c:url value="/event">
                        <c:param name="action" value="view" />
                        <c:param name="eID" value="<%= idString %>" />
                    (Event:
<%= e.getName() %>)<br /><%
        }
    }
%>

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