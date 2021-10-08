package com.jsy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jsy.service.aa.HelloService;

/**
 * @author: SongyangJi
 * @description:
 * @since: 2021/10/8
 */
public interface MyInterface {

    @Reference(interfaceClass = HelloService.class)
    String sayHello();

}
