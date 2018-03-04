package com.ppj.spring.cloud.weather.service;

import com.ppj.spring.cloud.weather.vo.WeatherResponse;

public interface WeatherDataService {

    /**
     * 根据城市编号查询天气数据
     * @param cityId 城市编号
     * @return WeatherResponse 响应数据
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     * @param cityName 城市名称
     * @return WeatherResponse 响应数据
     */
    WeatherResponse getDataByCityName(String cityName);
}
