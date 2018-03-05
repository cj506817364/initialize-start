package com.ppj.spring.cloud.weather.controller;


import com.ppj.spring.cloud.weather.service.IpAddressService;
import com.ppj.spring.cloud.weather.service.WeatherDataService;
import com.ppj.spring.cloud.weather.util.IpUtil;
import com.ppj.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AddressController {

    @Autowired
    private IpAddressService ipAddressService;

    @RequestMapping("/address")
    public String hello(HttpServletRequest request){
        String ip = IpUtil.getIpAdrress(request);
        return ipAddressService.getSubdivision(ip);

    }
}
