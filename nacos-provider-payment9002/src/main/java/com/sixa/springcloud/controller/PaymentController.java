package com.sixa.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
  @Value("${server.port}")
  private String port;
  @GetMapping("/payment")
  public String payment_port(){
    return "payment_"+port;
  }
}
