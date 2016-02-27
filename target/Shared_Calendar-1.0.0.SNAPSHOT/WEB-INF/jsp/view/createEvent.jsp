<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
</head>
<body>
<h1>Enter the Event details</h1>
<br/>
<br/>
<form action="" method="POST">
    <fieldset>
        <legend><em>Personal Information</em></legend><br/>
        <label>Event name: </label><span> <input type="text" name="eventName"></span>
        <br/><br/>
        <label>Event Date: </label> <span> <input type="date" name="eventDate"></span>
        <label>Event Description: </label> <span> <input type="text" name="Description"></span>
        <br/><br/>
        <input type="submit" value="Submit">
    </fieldset>
</form>
</body>
</html>