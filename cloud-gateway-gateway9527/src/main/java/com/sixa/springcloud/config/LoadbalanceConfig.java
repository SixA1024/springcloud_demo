package com.sixa.springcloud.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class LoadbalanceConfig {
  @Bean
  public RandomRule getRandomRule(){
    return new RandomRule();
  }
}
