package com.example.consumer.controller;

import com.example.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：消费端控制器
 * @Author :zks
 * @Date :16:18 2020/8/27
 */
@RequestMapping("consumer")
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    /**方式一：RestTemplate调用
     * @return
     */
    @RequestMapping("getName")
    public String getName(){
        return consumerService.getName() + "----已抵达8764端口consumer";
    }
}

