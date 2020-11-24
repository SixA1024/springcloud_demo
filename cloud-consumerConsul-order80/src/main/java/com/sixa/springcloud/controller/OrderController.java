package com.sixa.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

  public static final String PAYMENT_URL = "http://cloud-payment-service";
  @Autowired
  private RestTemplate restTemplate;
  @GetMapping("/consumer/payment/consul")
  public String paymentConsul(){
    return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
  }
}
