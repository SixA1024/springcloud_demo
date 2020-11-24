package com.sixa.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sixa.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImp implements PaymentService {
  @Override
  public String payment_ok() {
    return "线程："+Thread.currentThread().getName()+"payment_ok:"+"hahaha";
  }

  @Override
  @HystrixCommand(fallbackMethod = "payment_timeout_handler",commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
  })
  public String payment_timeout() {
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "线程:"+Thread.currentThread().getName()+"payment_timeout:"+"hehehe";
  }

  @Override
  @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
          @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
          @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
          @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
          @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
  })
  public String circuit(int id) {
    if (id < 0) {
      throw new RuntimeException();
    }
    return "线程:"+Thread.currentThread().getName()+"卧槽 哈哈:"+id;
  }

  public String paymentCircuitBreaker_fallback(int id){
    return "id 不能为负数,id:"+id;
  }

  public String payment_timeout_handler() {
    return "线程:"+Thread.currentThread().getName()+"服务器忙:"+"（o_o）";
  }
}
