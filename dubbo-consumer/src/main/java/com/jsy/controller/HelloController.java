package com.jsy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.jsy.service.aa.HelloService;
import lombok.Getter;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author: Song yang Ji
 * @ProjectName: learn-dubbo
 * @Version 1.0
 * @Description:
 */

@RestController
public class HelloController {
//     @Reference 会自动注入 dubbo 服务
    @DubboReference
    private HelloService helloService;

//    MyInterface helloService;

    @GetMapping("helloAsync")
    public String helloAsync() throws ExecutionException, InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("sayHelloAsync");
        CompletableFuture<String> stringCompletableFuture = helloService.sayHelloAsync();
        stopWatch.stop();

        stopWatch.start("future get");
        String s = stringCompletableFuture.get();
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());

        return s;
    }

    @GetMapping("hello")
    public String hello() throws InterruptedException, ExecutionException {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("rpc1");
        String s1 = helloService.sayHello();
        Future<String> future1 = RpcContext.getContext().getFuture();
        String f1 = future1.get();
        stopWatch.stop();

        stopWatch.start("rpc2");
        String s2 = helloService.sayHello();
        Future<String> future2 = RpcContext.getContext().getFuture();
        String f2 = future2.get();
        stopWatch.stop();




        System.out.println("直接拿 : "+s1 + " , " + s2);
        System.out.println("future get : "+f1 + " , " + f2);
        System.out.println(stopWatch.prettyPrint());
        return "end";
    }

}
