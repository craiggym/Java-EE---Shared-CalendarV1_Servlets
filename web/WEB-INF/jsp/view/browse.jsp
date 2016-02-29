<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.*" %>
<%@ page import="com.Calendar.Event" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Bharath</title>
            <%    @SuppressWarnings("unchecked")

     Map<Integer,Event> Events= (Map<Integer, Event>)request.getAttribute("eventDatabase");%>
    </head>
    <body>
        <h1>Event page</h1>

        <% if(session.getAttribute("username")==null){%>
            <h2><a href="register">Link to Register</a></h2>
            <form action="home?action=login" method="POST">
             Username: <input type="text" name="user"/><br>
             Password: <input type="password" name="pass"/><br>
             <input type="submit" value="login"/><br>
        <%}else{%>
             <form action="event?create_event" method="POST">
             <input type="submit" Value="User Page">
             </form>
        <%}%>

        <br>
        <hr><hr>


        <form action="event?action=userEventView" method="POST">
            <input type="submit" value="like">
        </form>
        <br/>
        <hr/>
                    <%if (Events != null){
                    for(Event name : Events.values()) {
                Integer id = name.getId();
                Date date = name.getEventDate();
                String eventName = name.getEventName();
                String desc = name.getDescription();
                String username = name.getUsername();%>
                <p><b>Event id:</b></p><%=id%><br/>
                <p><b>Event Date:</b></p><%=date%><br/>
                <p><b>Event Name:</b></p><%=eventName%><br/>
                <p><b>Event Description:</b></p><%=desc%><br/>
                <p><b>Created By:</b></p><%=username %><br/><br/>
            <% }
            }%>

    </body>
</html>
