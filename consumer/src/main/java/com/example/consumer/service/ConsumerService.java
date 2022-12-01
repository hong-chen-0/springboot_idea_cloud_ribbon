package com.example.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description：使用RestTemplate调用注册子模块接口方法
 * @Author :zks
 * @Date :16:14 2020/8/27
 */
@Service
public class ConsumerService {

    @LoadBalanced
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "consumerError" )
    public String getName() {
        //调用子模块接口地址
        String name = restTemplate.getForObject("http://service-provider/test/getName", String.class);
        return name;
    }

    public String consumerError() {
        return "sorry,this is ribbon hystrix  error";
    }
}

