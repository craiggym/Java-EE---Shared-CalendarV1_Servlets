<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Bharath</title>
    </head>
    <body>
        <h1>Event page</h1>
        <h2><a href="register">Link to Register</a></h2>
        <% if(session.getAttribute("username")==null){%>
    <form action="home?action=login" method="POST">
       Username: <input type="text" name="user"/><br>
       Password: <input type="password" name="pass"/><br>
        <input type="submit" value="login"/><br>
    <%}else{%>
        <form action="event" method="POST">
            <input type="submit" Value="User Page">
        </form>
        <%}%>

        <br>
        <hr><hr>
    </form>
    </body>
</html>
