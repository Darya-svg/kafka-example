package com.kafka.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class ScheduledTask {

  private KafkaTemplate<Long, String> kafkaTemplate;

  @Autowired
  public ScheduledTask(
      KafkaTemplate<Long, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Scheduled(fixedDelay = 5000)
  public void sendMessage() {
    kafkaTemplate.send("my_topic", "Hi Welcome to Spring For Apache Kafka");
  }

}
