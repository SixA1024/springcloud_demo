package com.sixa.springcloud.controller;

import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.pojo.Payment;
import com.sixa.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
  @Autowired
  private PaymentService paymentService;

  @GetMapping("/consumer/payment")
  public CommonResult<Payment> add(Payment payment){
    return paymentService.add(payment);
  }
  @GetMapping("/consumer/payment/{id}")
  public CommonResult<Payment> findById(@PathVariable("id") long id){
    return paymentService.findById(id);
  }
}
