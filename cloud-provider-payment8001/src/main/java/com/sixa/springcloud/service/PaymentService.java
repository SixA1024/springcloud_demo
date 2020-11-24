package com.sixa.springcloud.service;

import com.sixa.springcloud.pojo.Payment;

public interface PaymentService {
  int add(Payment payment);

  Payment findById(long id);
}
