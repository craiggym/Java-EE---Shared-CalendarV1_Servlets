<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css"/>
</head>
<body>
<h1></h1>
<br/>
<br/>
<form action="event?action=add_event" method="POST">
    <fieldset>
        <legend><em>Event Details</em></legend><br/>
        <label>Event name: </label><span> <input type="text" name="eventName"></span>
        <br/><br/>
        <label>Event Date: </label>
        <select name="month">
            <option value="_01">jan</option>
            <option value="_02">feb</option>
            <option value="_03">mar</option>
            <option value="_04">apr</option>
            <option value="_05">may</option>
            <option value="_06">jun</option>
            <option value="_07">jul</option>
            <option value="_08">aug</option>
            <option value="_09">sep</option>
            <option value="_10">oct</option>
            <option value="_11">nov</option>
            <option value="_12">dec</option>
        </select>
        <select name="date">
            <option value="_01">01</option>
            <option value="_02">02</option>
            <option value="_03">03</option>
            <option value="_04">04</option>
            <option value="_05">05</option>
            <option value="_06">06</option>
            <option value="_07">07</option>
            <option value="_08">08</option>
            <option value="_09">09</option>
            <option value="_10">10</option>
            <option value="_11">11</option>
            <option value="_12">12</option>
            <option value="_13">13</option>
            <option value="_14">14</option>
            <option value="_15">15</option>
            <option value="_16">16</option>
            <option value="_17">17</option>
            <option value="_18">18</option>
            <option value="_19">19</option>
            <option value="_20">20</option>
            <option value="_21">21</option>
            <option value="_22">22</option>
            <option value="_23">23</option>
            <option value="_24">24</option>
            <option value="_25">25</option>
            <option value="_26">26</option>
            <option value="_27">27</option>
            <option value="_28">28</option>
            <option value="_29">29</option>
            <option value="_30">30</option>
            <option value="_31">31</option>
        </select>
        <br/><br/>
        Event Description:
        <textarea name='Description' id='edescription' style="margin-left: 8px;"></textarea>
        <input type="submit" value="Submit">
    </fieldset>
</form>
</body>
</html>