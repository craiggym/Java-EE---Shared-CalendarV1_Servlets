<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Bharath</title>
    </head>
    <body>
        <h1>Event page</h1>
        <p style="color:darkred">Incorrect username/password</p>
        <h2><a href="register">Link to Register</a></h2>
    <form action="home?action=login" method="POST">
       Username: <input type="text" name="user"/><br>
       Password: <input type="password" name="pass"/><br>
        <input type="submit" value="login"/><br>

        <br>
        <hr><hr>
    </form>
    </body>
</html>
