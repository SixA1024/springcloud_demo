package com.sixa.springcloud.service;

import com.sixa.springcloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "seata-storage-service")
public interface StorageService {

  @PutMapping("/storage/{productId}/{count}")
  CommonResult decrease(@PathVariable("productId")Long id,@PathVariable("count")Integer count);
}
