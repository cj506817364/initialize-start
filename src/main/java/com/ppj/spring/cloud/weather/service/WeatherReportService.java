package com.ppj.spring.cloud.weather.service;

import com.ppj.spring.cloud.weather.vo.Weather;

public interface WeatherReportService {
    /**
     * 根据城市名称查询天气
     * @param cityName
     * @return
     */
    Weather getDataByCityName(String cityName);
}
