package com.sixa.springcloud.controller;

import com.sixa.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

  @Autowired
  private PaymentService paymentService;

  @GetMapping("/consumer/payment")
  public String payment() {
    return paymentService.payment();
  }
}
