package com.sixa.springcloud.controller;

import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.pojo.Order;
import com.sixa.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
  @Autowired
  private OrderService orderService;

  @PostMapping("/order")
  public CommonResult create(Order order){
    orderService.create(order);
    return new CommonResult(200,"订单创建成功!");
  }
}
