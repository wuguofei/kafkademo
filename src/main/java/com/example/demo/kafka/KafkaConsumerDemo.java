package com.example.demo.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerDemo {

  private KafkaConsumer<String, String> consumer;

  public void start() {
    initKfkaConsumer();
    getMessageFromKafka();
  }

  private void getMessageFromKafka() {
    while (true) {
      ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
      for (ConsumerRecord<String, String> record : records) {
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("partition = %d offset = %d, key = %s, value = %s%n", record.partition(),record.offset(), record.key(), record.value());
      }
    }
  }

  private void initKfkaConsumer() {
    Properties props = new Properties();
    //kafka集群
    props.put("bootstrap.servers", "localhost:9092");
    //反序列化类，要和producer的序列化对应
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("group.id", "test.group");

    consumer = new KafkaConsumer<>(props);
    //主题，从哪个主题取消息
    consumer.subscribe(Arrays.asList("test_kafka_topic"));

  }

  public static void main(String[] args) {
    new KafkaConsumerDemo().start();
  }

}
