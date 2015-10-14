<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <title>Weather Now</title>
</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="js/file.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


<script type="text/javascript">
    var updateIntervalMs = 10000;
    initializeWeatherYandex('table1', 'weatherYandexOrenburg.html');
    initializeWeatherYandex('table2', 'weatherYandexYekaterinburg.html');
    initializeWeatherYandex('table3', 'weatherYandexMoscow.html');
    initializeWeatherWunderground('table4', 'weatherWundergroundOrenburg.html');
    initializeWeatherWunderground('table5', 'weatherWundergroundYekaterinburg.html');
    initializeWeatherWunderground('table6', 'weatherWundergroundMoscow.html');

    updateWeatherYandex('table1', 'weatherYandexOrenburg.html', updateIntervalMs);
    updateWeatherYandex('table2', 'weatherYandexYekaterinburg.html', updateIntervalMs);
    updateWeatherYandex('table3', 'weatherYandexMoscow.html', updateIntervalMs);
    updateWeatherWunderground('table4', 'weatherWundergroundOrenburg.html', updateIntervalMs);
    updateWeatherWunderground('table5', 'weatherWundergroundYekaterinburg.html', updateIntervalMs);
    updateWeatherWunderground('table6', 'weatherWundergroundMoscow.html', updateIntervalMs);
</script>

<body>
<a href="view">
    <input type="button" value="To Database >>" name="ToDb"/>
</a>

Update Time: 10 sec
<center>
    <h1>
        Yandex
    </h1>

    <div id="table1">
        <%@include file="_weatherTable.html" %>
    </div>

    <div id="table2">
        <%@include file="_weatherTable.html" %>
    </div>

    <div id="table3">
        <%@include file="_weatherTable.html" %>
    </div>

    <h1>
        Wunderground
    </h1>

    <div id="table4">
        <%@include file="_weatherTable.html" %>
    </div>

    <div id="table5">
        <%@include file="_weatherTable.html" %>
    </div>

    <div id="table6">
        <%@include file="_weatherTable.html" %>
    </div>
</center>
</body>
</html>