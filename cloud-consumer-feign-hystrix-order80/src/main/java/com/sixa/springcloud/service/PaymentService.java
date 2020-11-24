package com.sixa.springcloud.service;

import com.sixa.springcloud.service.impl.PaymentServiceImp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cloud-payment-service",fallback = PaymentServiceImp.class)
public interface PaymentService {
  @GetMapping("/payment/hystrix/ok")
  public String payment_ok();

  @GetMapping("/payment/hystrix/timeout")
  public String payment_timeout();

  @GetMapping("/payment/circuit/{id}")
  public String circuit(@PathVariable("id")int id);
}
