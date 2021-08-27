package com.jsy.service.impl;


import com.jsy.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Song yang Ji
 * @ProjectName: learn-dubbo
 * @Version 1.0
 * @Description:
 */

@Service
// com.alibaba.dubbo.config.annotation.Service 是 Alibaba 包下的注解，表明这是 dubbo 服务提供者
@com.alibaba.dubbo.config.annotation.Service
public class HelloServiceImpl implements HelloService {

    AtomicInteger integer = new AtomicInteger();

    @Override
    public String sayHello() {
        System.out.println("Dubbo 服务者");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Dubbo 服务者: Hello world " + integer.incrementAndGet();
    }
}
