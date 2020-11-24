package com.sixa.springcloud.service.impl;

import com.sixa.springcloud.dao.AccountDao;
import com.sixa.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
@Slf4j
public class AccountServiceImp implements AccountService {
  @Autowired
  private AccountDao accountDao;
  @Override
  public void decrease(Long userId, BigDecimal money) {
    log.info("--------------------开始扣减账户");
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    accountDao.update(userId,money);
  }
}
