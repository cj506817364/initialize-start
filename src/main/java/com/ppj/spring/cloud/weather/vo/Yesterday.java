package com.ppj.spring.cloud.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * "yesterday": {
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
 }
 */
@Data
public class Yesterday  implements Serializable {
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
