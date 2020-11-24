package com.sixa.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
  @GetMapping("/consumer/payment/{id}")
  @SentinelResource(value = "payment_get",blockHandler = "blockHandler")
  public CommonResult<Payment> findById(@PathVariable("id")int id){
    return paymentService.findById(id);
  }

  public CommonResult<Payment> blockHandler(int id, BlockException e){
    Payment payment = new Payment(id,null);
    return new CommonResult<Payment>(444,"blockHandler_服务降级+"+e.getMessage(),payment);
  }

}
