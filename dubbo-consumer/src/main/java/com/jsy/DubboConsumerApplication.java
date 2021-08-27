package com.jsy;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Song yang Ji
 * @ProjectName: learn-dubbo
 * @Version 1.0
 * @Description:
 */

// 扫描 @Reference 注解
@EnableDubbo
@SpringBootApplication
public class DubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class,args);
    }
}
