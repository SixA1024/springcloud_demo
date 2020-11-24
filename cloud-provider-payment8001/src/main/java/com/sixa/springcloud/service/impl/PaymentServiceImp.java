package com.sixa.springcloud.service.impl;

import com.sixa.springcloud.dao.PaymentDao;
import com.sixa.springcloud.pojo.Payment;
import com.sixa.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImp implements PaymentService {
  @Resource
  private PaymentDao paymentDao;
  @Override
  public int add(Payment payment) {
    return paymentDao.add(payment);
  }

  @Override
  public Payment findById(long id) {
    return paymentDao.findById(id);
  }
}
