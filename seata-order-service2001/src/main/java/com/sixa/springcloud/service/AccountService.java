package com.sixa.springcloud.service;

import com.sixa.springcloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;

@FeignClient(name = "seata-account-service")
public interface AccountService {
  @PutMapping("/account/{userId}/{money}")
  CommonResult decrease(@PathVariable("userId")Long id, @PathVariable("money") BigDecimal money);
}
