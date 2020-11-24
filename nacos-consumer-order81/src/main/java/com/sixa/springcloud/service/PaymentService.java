package com.sixa.springcloud.service;

import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "nacos-payment-service",fallback = PaymentFallbackService.class)
public interface PaymentService {
  @GetMapping("/payment/{id}")
  public CommonResult<Payment> findById(@PathVariable("id")int id);
}
