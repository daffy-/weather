package centreIT.weatherServices;

import centreIT.WeatherObject;
import centreIT.xml.XMLParser;
import org.dom4j.Document;
import org.dom4j.DocumentException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WeatherWunderground {
    private static final String WUNDERGROUND_API_KEY = "335a58b028e33bdd";
    private static final String URL_RAW_WUNDERGROUND = "http://api.wunderground.com/api/" +
            WUNDERGROUND_API_KEY + "/geolookup/conditions/forecast/q/Russia/";
    private static final String ID_ORENBURG = "Orenburg";
    private static final String ID_MOSCOW = "Moskva";
    private static final String ID_EKATERINBURG = "Yekaterinburg";

    private Map weatherMap;

    private Map getCityWeather(String cityID) throws MalformedURLException, DocumentException {
        URL url = new URL(URL_RAW_WUNDERGROUND + cityID + ".xml");
        this.weatherMap = new HashMap<String, String>();

        Document doc = XMLParser.getDocument(url);
        String city = doc.selectSingleNode("/*[name()='response']/*[name()='location']/*[name()='city']").getText();
        String temperature = doc.selectSingleNode("/*[name()='response']/*[name()='current_observation']/*[name()='temp_c']").getText();
        String weatherType = doc.selectSingleNode("/*[name()='response']/*[name()='current_observation']/*[name()='weather']").getText();
        String humidity = doc.selectSingleNode("/*[name()='response']/*[name()='current_observation']/*[name()='relative_humidity']").getText();
        String pressure = doc.selectSingleNode("/*[name()='response']/*[name()='current_observation']/*[name()='pressure_mb']").getText();
        String uptime = doc.selectSingleNode("/*[name()='response']/*[name()='current_observation']/*[name()='observation_time_rfc822']").getText();
        String iconURL = doc.selectSingleNode("/*[name()='response']/*[name()='current_observation']/*[name()='icon_url']").getText();

        weatherMap.put("city", city);
        weatherMap.put("temperature", temperature);
        weatherMap.put("weatherType", weatherType);
        weatherMap.put("humidity", humidity);
        weatherMap.put("pressure", pressure);
        weatherMap.put("uptime", uptime);
        weatherMap.put("iconURL", iconURL);
        weatherMap.put("service", "Wunderground");

        return weatherMap;
    }

    public Map getOrenburgWeather() throws MalformedURLException, DocumentException {
        return getCityWeather(ID_ORENBURG);
    }

    public Map getYekaterinburgWeather() throws MalformedURLException, DocumentException {
        return getCityWeather(ID_EKATERINBURG);
    }

    public Map getMoscowWeather() throws MalformedURLException, DocumentException {
        return getCityWeather(ID_MOSCOW);
    }

    public Map getWeatherMap() {
        return weatherMap;
    }

    public WeatherObject toWeatherObject() {
        return new WeatherObject(
                this.weatherMap.get("city").toString(),
                Integer.parseInt(this.weatherMap.get("temperature").toString()),
                this.weatherMap.get("weatherType").toString(),
                Integer.parseInt(this.weatherMap.get("pressure").toString()),
                this.weatherMap.get("humidity").toString(),
                this.weatherMap.get("iconURL").toString(),
                this.weatherMap.get("uptime").toString(),
                this.weatherMap.get("service").toString()
        );
    }
}
