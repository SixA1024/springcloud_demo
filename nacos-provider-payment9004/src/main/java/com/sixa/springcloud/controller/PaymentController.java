package com.sixa.springcloud.controller;

import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

  @Value("${server.port}")
  private String port;

  private static Map<Integer,Payment> payments = new HashMap<>();
  static {
    payments.put(0,new Payment(1,"adc"));
    payments.put(1,new Payment(2,"def"));
    payments.put(2,new Payment(3,"ghi"));
  }

  @GetMapping("/payment/{id}")
  public CommonResult<Payment> findById(@PathVariable("id")int id){
    if (payments.get(id) != null) {
      return new CommonResult<Payment>(200,"查询成功,port:"+port,payments.get(id));
    } else {
      return new CommonResult<>(444,"没有数据,port:"+port,null);
    }
  }
}
