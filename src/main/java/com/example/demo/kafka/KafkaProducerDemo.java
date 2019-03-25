package com.example.demo.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerDemo {

  private Producer<String, String> producer;

  public void start() {
    initKafkaProducer();
    sendMsgToKafka();
  }

  private void sendMsgToKafka() {
    ProducerRecord<String, String> record = new ProducerRecord<>("test_kafka_topic", "TestKafkaKey", "this is the test message");
    producer.send(record);
    producer.close();

  }

  private void initKafkaProducer() {
    Properties props = new Properties();
    //kafka集群
    props.put("bootstrap.servers", "localhost:9092");
    // 配置value的序列化类
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    // 配置key的序列化类
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("group.id", "test.group");
    producer = new KafkaProducer<String, String>(props);
  }

  public static void main(String[] args) {
    new KafkaProducerDemo().start();
  }
}
