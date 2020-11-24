package com.sixa.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-payment-service")
public interface PaymentService {
  @GetMapping("/payment")
  public String payment();
}
