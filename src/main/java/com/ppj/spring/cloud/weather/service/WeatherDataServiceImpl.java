package com.ppj.spring.cloud.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppj.spring.cloud.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * https://www.sojson.com/open/api/weather/json.shtml?city=深圳
 */
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService{
    private static final String WEATHER_URI = "https://www.sojson.com/open/api/weather/json.shtml?";
    private static final long TIMEOUT = 10L;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;

        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;

        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri){

        String key = uri;

        String strBody = null;
        WeatherResponse resp = null;
        ObjectMapper mapper = new ObjectMapper();
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();

        //先查缓存
        if(stringRedisTemplate.hasKey(key)){
            log.info("Redis has data");
            strBody = ops.get(key);
        } else {
            log.info("Redis don't has data");
            //如果缓存没有，再调用
            ResponseEntity<String> respString = restTemplate.getForEntity(uri,String.class);
            if(respString.getStatusCodeValue() == 200){
                strBody = respString.getBody();
            }
            ops.set(uri,strBody,TIMEOUT, TimeUnit.SECONDS);
        }

        try {
            resp = mapper.readValue(strBody,WeatherResponse.class);
        } catch (Exception e){
//            e.printStackTrace();
            log.info("Error",e);
        }
        return resp;
    }
}
