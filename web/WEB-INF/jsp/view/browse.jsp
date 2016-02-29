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

    Map<String, LinkedList<Event>> eventDatabase =
            (Map<String, LinkedList<Event>>)request.getAttribute("eventDatabase");%>
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
                    <%
       if(eventDatabase != null){
       for(String name : eventDatabase.keySet()){
            LinkedList<Event> e = eventDatabase.get(session.getAttribute("username"));// grab all values for key
            for(int i = 0; i < e.size(); i++)
                {
                    String eventName = e.get(i).getEventName();
                    Date eventDate = e.get(i).getEventDate();
                    String eventDesc = e.get(i).getDescription();
                    String eventUser = e.get(i).getUsername();
                    int eventID = e.get(i).getId();
                    %>
                Event: <%= eventName %> <br/>
                Date: <%= eventDate %> <br/>
                Description: <%= eventDesc %> <br/>
                User: <%= eventUser %> <br/>
                EventID: <%= eventID %> <br/>
                <br />
                    <%
                }
}

    }
%>

    </body>
</html>
