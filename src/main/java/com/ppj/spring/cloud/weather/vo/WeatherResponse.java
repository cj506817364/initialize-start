package com.ppj.spring.cloud.weather.vo;



import lombok.Data;

import java.util.Date;

import java.io.Serializable;
import java.util.Date;

/**
 * 天气数据响应对象
 * https://www.sojson.com/open/api/weather/json.shtml?city=深圳
 */
@Data
public class WeatherResponse  implements Serializable {
    private String date;//日期
    private String message;//消息
    private Integer status;//响应状态
    private String city;//城市
    private Integer count;//
    private Weather data;//天气数据

}
