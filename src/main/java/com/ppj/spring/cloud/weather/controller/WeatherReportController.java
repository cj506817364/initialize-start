package com.ppj.spring.cloud.weather.controller;

import com.ppj.spring.cloud.weather.service.WeatherReportService;
import com.ppj.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityName/{cityName}")
    public ModelAndView getReportByCityName(@PathVariable("cityName") String cityName,Model model){
        model.addAttribute("title","皮皮今的天气预报");
        model.addAttribute("cityName",cityName);
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("深圳");
        arrayList.add("武汉");
        arrayList.add("北京");
        arrayList.add("北京");
        arrayList.add("上海");
        arrayList.add("重庆");
        arrayList.add("海南");
        arrayList.add("厦门");
        arrayList.add("天津");
        arrayList.add("西安");
        arrayList.add("杭州");
        arrayList.add("贵阳");
        arrayList.add("南京");
        model.addAttribute("cityList",arrayList);
        model.addAttribute("report",weatherReportService.getDataByCityName(cityName));
        return new ModelAndView("weather/report","reportModel",model);
    }
}
