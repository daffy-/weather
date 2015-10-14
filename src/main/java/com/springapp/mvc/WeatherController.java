package com.springapp.mvc;

import centreIT.DAO.WeatherDAO;
import centreIT.weatherServices.WeatherWunderground;
import centreIT.weatherServices.WeatherYandex;
import org.dom4j.DocumentException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;

@Controller
public class WeatherController {

    @RequestMapping("/")
    public ModelAndView printWelcome(ModelMap model) {
        return new ModelAndView("now");
    }

    @RequestMapping(value = "/weatherYandexOrenburg", method = RequestMethod.POST)
    public
    @ResponseBody
    byte[] getWeatherYandexOrenburg() throws MalformedURLException, DocumentException, UnsupportedEncodingException {
        WeatherYandex weatherYandex = new WeatherYandex();
        weatherYandex.getOrenburgWeatherMap();
        weatherYandex.toWeatherObject().save();
        return new JSONObject(weatherYandex.getWeatherMap()).toString().getBytes("UTF-8");
    }

    @RequestMapping(value = "/weatherYandexYekaterinburg", method = RequestMethod.POST)
    public
    @ResponseBody
    byte[] getWeatherYandexYekaterinburg() throws MalformedURLException, DocumentException, UnsupportedEncodingException {
        WeatherYandex weatherYandex = new WeatherYandex();
        weatherYandex.getYekaterinburgWeatherMap();
        weatherYandex.toWeatherObject().save();
        return new JSONObject(weatherYandex.getWeatherMap()).toString().getBytes("UTF-8");
    }

    @RequestMapping(value = "/weatherYandexMoscow", method = RequestMethod.POST)
    public
    @ResponseBody
    byte[] getWeatherYandexMoscow() throws MalformedURLException, DocumentException, UnsupportedEncodingException {
        WeatherYandex weatherYandex = new WeatherYandex();
        weatherYandex.getMoscowWeatherMap();
        weatherYandex.toWeatherObject().save();
        return new JSONObject(weatherYandex.getWeatherMap()).toString().getBytes("UTF-8");
    }

    @RequestMapping(value = "/weatherWundergroundOrenburg", method = RequestMethod.POST)
    public
    @ResponseBody
    byte[] getWeatherWundergroundOrenburg() throws MalformedURLException, DocumentException, UnsupportedEncodingException {
        WeatherWunderground weatherWunderground = new WeatherWunderground();
        weatherWunderground.getOrenburgWeather();
        weatherWunderground.toWeatherObject().save();
        return new JSONObject(weatherWunderground.getWeatherMap()).toString().getBytes("UTF-8");
    }

    @RequestMapping(value = "/weatherWundergroundYekaterinburg", method = RequestMethod.POST)
    public
    @ResponseBody
    byte[] getWeatherWundergroundYekaterinburg() throws MalformedURLException, DocumentException, UnsupportedEncodingException {
        WeatherWunderground weatherWunderground = new WeatherWunderground();
        weatherWunderground.getYekaterinburgWeather();
        weatherWunderground.toWeatherObject().save();
        return new JSONObject(weatherWunderground.getWeatherMap()).toString().getBytes("UTF-8");
    }

    @RequestMapping(value = "/weatherWundergroundMoscow", method = RequestMethod.POST)
    public
    @ResponseBody
    byte[] getWeatherWundergroundMoscow() throws MalformedURLException, DocumentException, UnsupportedEncodingException {
        WeatherWunderground weatherWunderground = new WeatherWunderground();
        weatherWunderground.getMoscowWeather();
        weatherWunderground.toWeatherObject().save();
        return new JSONObject(weatherWunderground.getWeatherMap()).toString().getBytes("UTF-8");
    }

    public static ArrayList getAll() throws MalformedURLException, DocumentException, UnsupportedEncodingException {
        return new ArrayList(WeatherDAO.getAll());
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view() {
        ModelAndView model = new ModelAndView("history");
        model.addObject("weathers", WeatherDAO.getAll());
        return model;
    }

}