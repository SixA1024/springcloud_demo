package com.sixa.springcloud.dao;

import com.sixa.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
  public int add(Payment payment);

  public Payment findById(long id);
}
