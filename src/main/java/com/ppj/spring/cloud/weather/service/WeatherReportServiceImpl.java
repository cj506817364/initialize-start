package com.ppj.spring.cloud.weather.service;

import com.ppj.spring.cloud.weather.vo.Weather;
import com.ppj.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityName(String cityName) {
        WeatherResponse resp = weatherDataService.getDataByCityName(cityName);
        return resp.getData();
    }
}
