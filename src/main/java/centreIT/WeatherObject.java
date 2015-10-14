package centreIT;

import centreIT.DAO.WeatherDAO;

public class WeatherObject {

    private Long id;
    private String city;
    private int temperature;
    private String weatherType;
    private int pressure;
    private String humidity;
    private String iconURL;
    private String uptime;
    private String service;

    public WeatherObject() {}

    public WeatherObject(String city, int temperature, String weatherType, int pressure,
                         String humidity, String iconURL, String uptime, String service) {
        this.city = city;
        this.temperature = temperature;
        this.weatherType = weatherType;
        this.pressure = pressure;
        this.humidity = humidity;
        this.iconURL = iconURL;
        this.uptime= uptime;
        this.service= service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public void save() {
        WeatherDAO.add(this);
    }


}
