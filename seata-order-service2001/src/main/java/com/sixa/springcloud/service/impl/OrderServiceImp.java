package com.sixa.springcloud.service.impl;

import com.sixa.springcloud.dao.OrderDao;
import com.sixa.springcloud.pojo.Order;
import com.sixa.springcloud.service.AccountService;
import com.sixa.springcloud.service.OrderService;
import com.sixa.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImp implements OrderService {
  @Autowired
  private OrderDao orderDao;
  @Autowired
  private AccountService accountService;
  @Autowired
  private StorageService storageService;

  @Override
  @GlobalTransactional
  public void create(Order order) {
    log.info(order.toString());
    log.info("---------------------开始新建订单");
    orderDao.create(order);
    log.info("------------订单微服务调用库存微服务");
    storageService.decrease(order.getProductId(),order.getCount());
    log.info("----------------订单微服务调用账户微服务");
    accountService.decrease(order.getUserId(),order.getMoney());
    log.info("---------------------开始修改订单");
    orderDao.update(order.getUserId(),0);
  }
}
