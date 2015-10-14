function updateWeatherYandex(tableID, url, updateIntervalMs) {
    setInterval(function () {
        $.ajax({
            url: url,
            type: 'POST',
            dataType: 'json',
            success: function (data) {
                if (data['temperature'] > 0) {
                    $('#' + tableID + ' #temperature').html('+' + data['temperature']);
                } else {
                    $('#' + tableID + ' #temperature').html(data['temperature']);
                }
                $('#' + tableID + ' #city').html(data['city']);
                $('#' + tableID + ' #weatherType').html(data['weatherType']);
                $('#' + tableID + ' #iconURL').attr('src', data['iconURL']);
                $('#' + tableID + ' #humidity').html(data['humidity'] + '%');
                $('#' + tableID + ' #pressure').html(data['pressure'] + ' mm');
                $('#' + tableID + ' #uptime').html(data['uptime']);
            }
        });
    }, updateIntervalMs);
}

function updateWeatherWunderground(tableID, url, updateIntervalMs) {
    setInterval(function () {
        $.ajax({
            url: url,
            type: 'POST',
            dataType: 'json',
            success: function (data) {
                if (data['temperature'] > 0) {
                    $('#' + tableID + ' #temperature').html('+' + data['temperature']);
                } else {
                    $('#' + tableID + ' #temperature').html(data['temperature']);
                }
                $('#' + tableID + ' #city').html(data['city']);
                $('#' + tableID + ' #weatherType').html(data['weatherType']);
                $('#' + tableID + ' #iconURL').attr('src', data['iconURL']);
                $('#' + tableID + ' #humidity').html(data['humidity']);
                $('#' + tableID + ' #pressure').html(data['pressure'] + ' mb');
                $('#' + tableID + ' #uptime').html(data['uptime']);
            }
        });
    }, updateIntervalMs);
}

function initializeWeatherYandex(tableID, url) {
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'json',
        success: function (data) {
            if (data['temperature'] > 0) {
                $('#' + tableID + ' #temperature').html('+' + data['temperature']);
            } else {
                $('#' + tableID + ' #temperature').html(data['temperature']);
            }
            $('#' + tableID + ' #city').html(data['city']);
            $('#' + tableID + ' #weatherType').html(data['weatherType']);
            $('#' + tableID + ' #iconURL').attr('src', data['iconURL']);
            $('#' + tableID + ' #humidity').html(data['humidity'] + '%');
            $('#' + tableID + ' #pressure').html(data['pressure'] + ' mm');
            $('#' + tableID + ' #uptime').html(data['uptime']);
        }
    });
}

function initializeWeatherWunderground(tableID, url) {
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'json',
        success: function (data) {
            if (data['temperature'] > 0) {
                $('#' + tableID + ' #temperature').html('+' + data['temperature']);
            } else {
                $('#' + tableID + ' #temperature').html(data['temperature']);
            }
            $('#' + tableID + ' #city').html(data['city']);
            $('#' + tableID + ' #weatherType').html(data['weatherType']);
            $('#' + tableID + ' #iconURL').attr('src', data['iconURL']);
            $('#' + tableID + ' #humidity').html(data['humidity']);
            $('#' + tableID + ' #pressure').html(data['pressure'] + ' mb');
            $('#' + tableID + ' #uptime').html(data['uptime']);
        }
    });
}

