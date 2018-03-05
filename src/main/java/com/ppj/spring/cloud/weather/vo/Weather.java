package com.ppj.spring.cloud.weather.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息
 * https://www.sojson.com/open/api/weather/json.shtml?city=深圳
 * "data": {
         "shidu": "89%",
         "pm25": 36,
         "pm10": 51,
         "quality": "良",
         "wendu": "21",
         "ganmao": "极少数敏感人群应减少户外活动",
         "yesterday": {
             "date": "03日星期六",
             "sunrise": "06:45",
             "high": "高温 27.0℃",
             "low": "低温 21.0℃",
             "sunset": "18:28",
             "aqi": 49,
             "fx": "无持续风向",
             "fl": "<3级",
             "type": "多云",
             "notice": "阴晴之间，谨防紫外线侵扰"
             },
         "forecast": [
             {
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
             },
             {
             "date": "05日星期一",
             "sunrise": "06:43",
             "high": "高温 27.0℃",
             "low": "低温 18.0℃",
             "sunset": "18:29",
             "aqi": 32,
             "fx": "无持续风向",
             "fl": "<3级",
             "type": "阵雨",
             "notice": "阵雨来袭，出门记得带伞"
             },
             {
             "date": "06日星期二",
             "sunrise": "06:43",
             "high": "高温 22.0℃",
             "low": "低温 17.0℃",
             "sunset": "18:29",
             "aqi": 30,
             "fx": "无持续风向",
             "fl": "<3级",
             "type": "阵雨",
             "notice": "阵雨来袭，出门记得带伞"
             },
             {
             "date": "07日星期三",
             "sunrise": "06:42",
             "high": "高温 22.0℃",
             "low": "低温 14.0℃",
             "sunset": "18:30",
             "aqi": 31,
             "fx": "无持续风向",
             "fl": "<3级",
             "type": "多云",
             "notice": "阴晴之间，谨防紫外线侵扰"
             },
             {
             "date": "08日星期四",
             "sunrise": "06:41",
             "high": "高温 16.0℃",
             "low": "低温 13.0℃",
             "sunset": "18:30",
             "aqi": 41,
             "fx": "无持续风向",
             "fl": "<3级",
             "type": "阵雨",
             "notice": "阵雨来袭，出门记得带伞"
             }
         ]
 }
 */
@Data
public class Weather implements Serializable {
    private String shidu;//湿度
    private int pm25;//pm2.5
    private int pm10;//pm1.0
    private String quality;//天气质量
    private String wendu;//温度
    private String ganmao;//感冒
    private Yesterday yesterday;//昨日天气
    private List<Forecast> forecast;//预测

}
