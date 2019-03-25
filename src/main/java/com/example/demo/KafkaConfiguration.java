package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.kafka.KafkaConsumerDemo;
import com.example.demo.kafka.KafkaProducerDemo;

@Configuration
public class KafkaConfiguration {
  
  @Bean(initMethod = "start")
  public KafkaProducerDemo initProducer() {
    return new KafkaProducerDemo();
  }
  
  @Bean(initMethod = "start")
  public KafkaConsumerDemo initConsumer() {
    return new KafkaConsumerDemo();
  }
  

}
