package com.example.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：服务端控制器
 * @Author :zks
 * @Date :16:07 2020/8/27
 */
@RequestMapping("test")
@RestController
public class TestController {

    @RequestMapping("getName")
    public String getName(){
        return "SpringCloud!";
    }
}

