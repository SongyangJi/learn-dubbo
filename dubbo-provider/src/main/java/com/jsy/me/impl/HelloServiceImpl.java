package com.jsy.me.impl;


import com.jsy.service.aa.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * @Author: Song yang Ji
 * @ProjectName: learn-dubbo
 * @Version 1.0
 * @Description:
 */

@Component
@DubboService
public class HelloServiceImpl implements HelloService {

    AtomicInteger integer = new AtomicInteger();

    @Override
    public String sayHello() {
        System.out.println("Dubbo 服务者");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        int x = 1/0;
//        System.out.println(x);

        return "Dubbo 服务者: Hello world " + integer.incrementAndGet();
    }

    @Override
    public CompletableFuture<String> sayHelloAsync() {
        return CompletableFuture.supplyAsync(this::sayHello);
    }
}
