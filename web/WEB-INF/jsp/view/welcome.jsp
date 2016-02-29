<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.Calendar.Event" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.LinkedList" %>

<%
    @SuppressWarnings("unchecked")
    Map<String, LinkedList<Event>> eventDatabase =
            (Map<String, LinkedList<Event>>)request.getAttribute("eventDatabase");

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
    Object value = eventDatabase.get(session.getAttribute("userame"));
    if (value==null){
    if(eventDatabase == null || eventDatabase.size() == 0)
    {
%><h3>Not subscribed to any events!</h3> <br/><p><em>Create one or follow one from the All Events page!</em><p></p><%
}
else
{
    for(String eName : eventDatabase.keySet())
    {
        System.out.println("Username is " + session.getAttribute("username"));
        if(eName == session.getAttribute("username")){
            for(LinkedList<Event> name : eventDatabase.values()) // grab all values for key
            {
                if(eName != session.getAttribute("username")) break;
                LinkedList<Event> e = name;
                for(int i = 0; i < e.size(); i++)
                {
                    String eventName = e.get(i).getEventName();
                    Date eventDate = e.get(i).getEventDate();
                    String eventDesc = e.get(i).getDescription();
                    String eventUser = e.get(i).getUsername();
                    int eventID = e.get(i).getId();



%>Event: <%= eventName %> <br/>
 Date: <%= eventDate %> <br/>
 Description: <%= eventDesc %> <br/>
 User: <%= eventUser %> <br/>
 EventID: <%= eventID %> <br/>

<br /><%
                }}

                }else{}

        }
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