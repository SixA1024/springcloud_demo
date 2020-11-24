package com.sixa.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Order {
  private Long id;
  private Long userId;
  private Long productId;
  private Integer count;
  private BigDecimal money;
  private Integer status;
}
