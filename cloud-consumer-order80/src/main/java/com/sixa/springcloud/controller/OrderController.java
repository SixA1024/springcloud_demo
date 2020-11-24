package com.sixa.springcloud.controller;

import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
  public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
  @Autowired
  private RestTemplate restTemplate;
  @GetMapping("/consumer/payment")
  public CommonResult<Payment> add(Payment payment){
    return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommonResult.class);
  }
  @GetMapping("/consumer/payment/{id}")
  public CommonResult<Payment> findById(@PathVariable("id") long id){
    return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
  }
}
