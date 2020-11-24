package com.sixa.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sixa.springcloud.myhandler.CustomerBlockHandler;
import com.sixa.springcloud.pojo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceLimitController {
  @GetMapping("/byRes")
  @SentinelResource(value = "byRes",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException")
  public CommonResult byRes(){
    return new CommonResult(200,"哈哈","笑");
  }
}
