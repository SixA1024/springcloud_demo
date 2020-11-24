package com.sixa.springcloud.controller;

import com.sixa.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
  @Autowired
  private PaymentService paymentService;
  @GetMapping("/payment/hystrix/ok")
  public String payment_ok(){
    return paymentService.payment_ok();
  }
  @GetMapping("/payment/hystrix/timeout")
  public String payment_timeout(){
    return paymentService.payment_timeout();
  }
  @GetMapping("/payment/circuit/{id}")
  public String circuit(@PathVariable("id")int id){
    return paymentService.circuit(id);
  }
}
