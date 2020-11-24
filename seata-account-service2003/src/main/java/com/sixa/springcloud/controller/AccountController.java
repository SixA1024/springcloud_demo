package com.sixa.springcloud.controller;

import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {
  @Autowired
  private AccountService accountService;
  @PutMapping("/account/{userId}/{money}")
  public CommonResult decrease(@PathVariable("userId")Long id, @PathVariable("money")BigDecimal money){
    accountService.decrease(id,money);
    return new CommonResult(200,"扣减账户成功");
  }
}
