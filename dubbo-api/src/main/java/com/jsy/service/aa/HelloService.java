package com.jsy.service.aa;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: Song yang Ji
 * @ProjectName: learn-dubbo
 * @Version 1.0
 * @Description:
 */

public interface HelloService {
    String sayHello();

    CompletableFuture<String> sayHelloAsync();
}
