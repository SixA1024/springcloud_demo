package com.sixa.springcloud.service.impl;

import com.sixa.springcloud.dao.StorageDao;
import com.sixa.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServiceImp implements StorageService {
  @Autowired
  private StorageDao storageDao;
  @Override
  public void decrease(Long productId, Integer count) {
    log.info("-------------------扣减库存");
    storageDao.update(productId,count);
  }
}
