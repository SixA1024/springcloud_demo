package com.sixa.loadbalance;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalanceConfig {
  @Bean
  public RandomRule getRandomRule(){
    return new RandomRule();
  }
}
