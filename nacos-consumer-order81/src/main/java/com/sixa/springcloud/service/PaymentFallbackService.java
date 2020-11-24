package com.sixa.springcloud.service;

import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.pojo.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentService {
  @Override
  public CommonResult<Payment> findById(int id) {
    return new CommonResult<>(444,"PaymentFallbackService_服务降级",new Payment(id,null));
  }
}
