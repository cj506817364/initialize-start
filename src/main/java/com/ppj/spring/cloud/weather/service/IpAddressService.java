package com.ppj.spring.cloud.weather.service;

import cn.hutool.core.util.StrUtil;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/**
 * IP地址服务
 */
@Service
public class IpAddressService {

    private static Logger logger = LoggerFactory.getLogger(IpAddressService.class);

//    private static String dbPath = "/usr/local/GeoLite2-City.mmdb";

    @Autowired
    private static DatabaseReader reader;

    @Autowired
    private Environment env;

//    @PostConstruct
//    public void init() {
//        try {
//            String path = env.getProperty("geolite2.city.db.path");
//            if (StrUtil.isNotBlank(path)) {
//                dbPath = path;
//            }
//            File database = new File(dbPath);
//            reader = new DatabaseReader.Builder(database).build();
//        } catch (Exception e) {
//            logger.error("IP地址服务初始化异常:" + e.getMessage(), e);
//        }
//    }


    public String getSubdivision(String ipAddress){
        try {
            CityResponse response = reader.city(InetAddress.getByName(ipAddress));
            return response.getMostSpecificSubdivision().getNames().get("zh-CN");
        }catch (Exception e){
            logger.error("根据IP[{}]获取省份失败:{}", ipAddress, e.getMessage());
            return null;
        }
    }
}
