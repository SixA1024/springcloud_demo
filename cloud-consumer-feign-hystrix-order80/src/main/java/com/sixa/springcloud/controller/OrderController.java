package com.sixa.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sixa.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "payment_global_fallback")
public class OrderController {
  @Autowired
  private PaymentService paymentService;
  @GetMapping("/consumer/payment/hystrix/ok")
  public String payment_ok(){
    return paymentService.payment_ok();
  }

  @GetMapping("/consumer/payment/hystrix/timeout")
//  @HystrixCommand(fallbackMethod = "payment_timeout_handler",commandProperties = {
//          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//  })
  public String payment_timeout(){
    return paymentService.payment_timeout();
  }
  @GetMapping("/circuit/{id}")
  public String circuit(@PathVariable("id") int id){
    return paymentService.circuit(id);
  }

  public String payment_global_fallback(){
    return "系统繁忙 @Global_fallback";
  }
}
