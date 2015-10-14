<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet"
      href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript"
        src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

<script>
    $(document).ready(function () {
        $('#weatherTable').dataTable();
    });
</script>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>History Page</title>
</head>

<body>
<a href="/">
    <input type="button" value="<< Back" name="ToWeather"/>
</a>

<center>
    <h1>Weather history</h1>
</center>

<div class="table-responsive">
    <table id="weatherTable" class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>City</th>
            <th>Temp</th>
            <th>Weather Type</th>
            <th>Pressure</th>
            <th>Humidity</th>
            <th>Icon</th>
            <th>Uptime</th>
            <th>Service</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${weathers}" var="weather">
            <tr>
                <td>${weather.id}</td>
                <td>${weather.city}</td>
                <td>${weather.temperature}</td>
                <td>${weather.weatherType}</td>
                <td>${weather.pressure}</td>
                <td>${weather.humidity}</td>
                <td>${weather.iconURL}</td>
                <td>${weather.uptime}</td>
                <td>${weather.service}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
