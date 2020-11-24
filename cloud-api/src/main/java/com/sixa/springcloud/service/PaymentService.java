package com.sixa.springcloud.service;

import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "cloud-payment-service")
public interface PaymentService {
  @PostMapping("/payment")
  public CommonResult<Payment> add(Payment payment);

  @GetMapping("/payment/{id}")
  public CommonResult<Payment> findById(@PathVariable("id") long id);
}
