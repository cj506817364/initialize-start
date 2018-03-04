package com.ppj.spring.cloud.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * "forecast":{
     "date": "04日星期日",
     "sunrise": "06:44",
     "high": "高温 26.0℃",
     "low": "低温 21.0℃",
     "sunset": "18:29",
     "aqi": 30,
     "fx": "无持续风向",
     "fl": "<3级",
     "type": "阵雨",
     "notice": "阵雨来袭，出门记得带伞"
 }
 */
@Data
public class Forecast  implements Serializable {
    private String date;//日期    04日星期日
    private String sunrise;//太阳生气时间
    private String high;//最高温
    private String low;//最低温
    private String sunset;//太阳落下时间
    private int aqi;//
    private String fx;//风向
    private String fl;//风力
    private String type;//天气类型
    private String notice;//提示
}
