<%@ page import="java.util.*" %>
<%@ page import="com.Calendar.Event" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Created Events</title>
</head>
<body>
<h2>Events Created</h2>
<form action="event" method="POST">
    <input type="submit" value="Back">
</form>
<hr/>
<hr/>
<%    @SuppressWarnings("unchecked")

     Map<Integer,Event> Events= (Map<Integer, Event>)request.getAttribute("Created");

    /*if (null == session.getAttribute("username")) {
        return;
    }
   for(String key : Events.keySet())
    {
        out.println(key+ "<br/>" +"" + "<hr/>");


    }
*/
  /*  <select name="Eventss">
    <c:forEach items="${Events}" var="Eventss">
    <option value="${Eventss.key}">${Eventss.value}</option>
    </c:forEach>
    </select>*/

 /*   for(int i=(Events.size()Events.size()-1);i>0;i--)
    {


    }*/
for(int i=Events.size();i>0;i--) {%>

<p><b>Event id:</b></p><%=Events.get(i).getId()%><br/>
<p><b>Event Date:</b></p><%=Events.get(i).getEventDate()%><br/>
<p><b>Event Name:</b></p><%=Events.get(i).getEventName()%><br/>
<p><b>Event Description:</b></p><%=Events.get(i).getDescription()%><br/>
<p><b>Created By:</b></p><%=Events.get(i).getUsername() %><br/><hr/>
<% }%>
</body>
</html>