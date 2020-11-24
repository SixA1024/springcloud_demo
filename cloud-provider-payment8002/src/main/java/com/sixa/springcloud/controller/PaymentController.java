package com.sixa.springcloud.controller;


import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.pojo.Payment;
import com.sixa.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
  @Autowired
  private PaymentService paymentService;
  @Value("${server.port}")
  private String port;
  @Autowired
  private DiscoveryClient discoveryClient;
  @PostMapping("/payment")
  public CommonResult add(@RequestBody Payment payment){
    int result = paymentService.add(payment);
    log.info("*******插入结果"+result);
    if (result > 0) {
      return new CommonResult(200,"插入成功",result);
    } else {
      return new CommonResult(444,"插入失败",null);
    }
  }
  @GetMapping("/payment/{id}")
  public CommonResult<Payment> findById(@PathVariable("id") long id){
    Payment payment = paymentService.findById(id);
    log.info("查询结果"+payment+"\t哈哈");
    if (payment != null) {
      return new CommonResult(200,"查询成功,port:"+port,payment);
    } else {
      return new CommonResult(444,"没有记录，查询ID:"+id,null);
    }
  }
  @GetMapping("/payment/discovery")
  public Object discovery(){
    List<String> services = discoveryClient.getServices();
    for (String service : services) {
      log.info("**************service:"+service);
    }
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    log.info(instances.toString());
    return this.discoveryClient;
  }
}
