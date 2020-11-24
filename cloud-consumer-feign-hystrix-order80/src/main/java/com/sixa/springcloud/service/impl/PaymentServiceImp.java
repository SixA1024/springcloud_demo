package com.sixa.springcloud.service.impl;

import com.sixa.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImp implements PaymentService {
  @Override
  public String payment_ok() {
    return "PaymentServiceImp_payment_ok_o(╥﹏╥)o";
  }

  @Override
  public String payment_timeout() {
    return "PaymentServiceImp_payment_timeout_o(╥﹏╥)o";
  }

  @Override
  public String circuit(int id) {
    return null;
  }


}
