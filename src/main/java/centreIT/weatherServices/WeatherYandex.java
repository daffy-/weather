package centreIT.weatherServices;

import centreIT.WeatherObject;
import centreIT.xml.XMLParser;
import org.dom4j.Document;
import org.dom4j.DocumentException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WeatherYandex {
    private static final String URL_RAW_YANDEX = "http://export.yandex.ru/weather-ng/forecasts/";
    private static final String ICON_URL_RAW = "http://yandex.st/weather/1.2.61/i/icons/48x48/";
    private static final int ID_ORENBURG = 35121;
    private static final int ID_EKATERINBURG = 28440;
    private static final int ID_MOSCOW = 27612;

    private Map weatherMap;

    public Map getWeatherMap() {
        return weatherMap;
    }

    private Map getCityWeather(int cityID) throws MalformedURLException, DocumentException {
        URL url = new URL(URL_RAW_YANDEX + cityID + ".xml");
        this.weatherMap = new HashMap<String, String>();

        Document doc = XMLParser.getDocument(url);
        String city = doc.selectSingleNode("/*[name()='forecast']/@city").getText();
        String temperature = doc.selectSingleNode("/*[name()='forecast']/*[name()='fact']/*[name()='temperature']").getText();
        String weatherType = doc.selectSingleNode("/*[name()='forecast']/*[name()='fact']/*[name()='weather_type']").getText();
        String pressure = doc.selectSingleNode("/*[name()='forecast']/*[name()='fact']/*[name()='pressure']").getText();
        String humidity = doc.selectSingleNode("/*[name()='forecast']/*[name()='fact']/*[name()='humidity']").getText();
        String iconName = doc.selectSingleNode("/*[name()='forecast']/*[name()='fact']/*[name()='image-v3']").getText();
        String iconURL = ICON_URL_RAW + iconName + ".png";
        String uptime = doc.selectSingleNode("/*[name()='forecast']/*[name()='fact']/*[name()='uptime']").getText();

        weatherMap.put("city", city);
        weatherMap.put("temperature", temperature);
        weatherMap.put("weatherType", weatherType);
        weatherMap.put("pressure", pressure);
        weatherMap.put("humidity", humidity);
        weatherMap.put("iconURL", iconURL);
        weatherMap.put("uptime", uptime);
        weatherMap.put("service", "Yandex");

        return weatherMap;
    }

    public Map getOrenburgWeatherMap() throws MalformedURLException, DocumentException {
        return getCityWeather(ID_ORENBURG);
    }

    public Map getYekaterinburgWeatherMap() throws MalformedURLException, DocumentException {
        return getCityWeather(ID_EKATERINBURG);
    }

    public Map getMoscowWeatherMap() throws MalformedURLException, DocumentException {
        return getCityWeather(ID_MOSCOW);
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
