package com.sixa.springcloud.service;

public interface PaymentService {
  String payment_ok();

  String payment_timeout();

  String circuit(int id);
}
