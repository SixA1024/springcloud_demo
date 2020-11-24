package com.sixa.springcloud.controller;

import com.sixa.springcloud.pojo.CommonResult;
import com.sixa.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {
  @Autowired
  private StorageService storageService;
  @PutMapping("/storage/{productId}/{count}")
  public CommonResult decrease(@PathVariable("productId")Long id, @PathVariable("count")Integer count){
    System.out.println(count);
    storageService.decrease(id,count);
    return new CommonResult(200,"扣减库存成功");
  }
}
