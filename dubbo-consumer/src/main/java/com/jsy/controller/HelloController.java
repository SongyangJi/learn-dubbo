package com.jsy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jsy.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Song yang Ji
 * @ProjectName: learn-dubbo
 * @Version 1.0
 * @Description:
 */

@RestController
public class HelloController {
    // @Reference 会自动注入 dubbo 服务
    @Reference
    private HelloService helloService;

    @GetMapping("hello")
    public String hello() {
        System.out.println("消费者消费前");
        long l = System.currentTimeMillis();
        String s = helloService.sayHello();
        System.out.println("to here");
        System.out.println(s);
        String s1 = helloService.sayHello();
        System.out.println(s1);
        long r = System.currentTimeMillis();
        System.out.println("gap : "+(r - l) + " ms");
        System.out.println("消费者消费后");
        return s;
    }

}
