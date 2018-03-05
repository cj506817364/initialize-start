package com.ppj.spring.cloud.weather.controller;

import com.ppj.spring.cloud.weather.service.WeatherDataService;
import com.ppj.spring.cloud.weather.vo.Weather;
import com.ppj.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://www.sojson.com/open/api/weather/json.shtml?city=深圳
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @RequestMapping("/cityName/{cityName}")
    public WeatherResponse hello(@PathVariable String cityName){
        WeatherResponse we = new WeatherResponse();
        we.setCity("wuhan");
        System.out.println(we.getCity());
        return weatherDataService.getDataByCityName(cityName);
    }


}
