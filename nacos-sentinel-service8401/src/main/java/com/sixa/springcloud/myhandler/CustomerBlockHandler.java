package com.sixa.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sixa.springcloud.pojo.CommonResult;

public class CustomerBlockHandler {

  public static CommonResult handlerException(BlockException exception){
    return new CommonResult(444,"服务不可用","o(╥﹏╥)o");
  }
}
