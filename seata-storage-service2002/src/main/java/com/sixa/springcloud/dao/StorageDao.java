package com.sixa.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
  void update(@Param("productId") Long productId, @Param("count") Integer count);
}
