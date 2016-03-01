<%@ page import="java.util.*" %>
<%@ page import="com.Calendar.Event" %>
<%@ page import="com.Calendar.EventServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
            <%    @SuppressWarnings("unchecked")

    Map<String, List<Event>> eventDatabase =
          EventServlet.eventDatabase;%>
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
            <form action="home?action=logout" method="POST">
                <input type="submit" value="Log out"><br/>
            </form>
        <%}%>

        <br>
        <hr><hr>

        <br/>
        <hr/>
                    <% // Display message if the user has no events
   if(eventDatabase == null)
%><h3>There are no events created</h3> <br/><p><em>Create one or follow one from the All Events page!</em><p></p>
                    <%
       if(eventDatabase != null){
       for(String name : eventDatabase.keySet()){
            List<Event> e = eventDatabase.get(name);// grab all values for key
            for(int i = 0; i < e.size(); i++)
                {
                    String eventName = e.get(i).getEventName();
                    String eventDate = e.get(i).getEventDate();
                    String eventDesc = e.get(i).getDescription();
                    String eventUser = e.get(i).getUsername();
                    int eventID = e.get(i).getId();
                    %>
                Event: <%= eventName %> <br/>
                Date: <%= eventDate %> <br/>
                Description: <%= eventDesc %> <br/>
                User: <%= eventUser %> <br/>
                EventID: <%= eventID %> <br/>
                <% if(session.getAttribute("username") !=null){%>
                <form action="event?action=add_event" method="POST">
                    <span eventName=<%= eventName%>/>
                    <span eventDescription=<%= eventDesc%>/>
                    <span userName=<%= eventUser%>/>
                    <input type="submit" value="Like">
                </form>
                    <%
                    }%><br/><%
                }
}

    }
%>


    </body>
</html>
