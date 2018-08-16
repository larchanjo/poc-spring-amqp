package com.poc.springamqp.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Luram Archanjo / 20180816
 */
@Configuration
@Slf4j
public class AmqpConfiguration {

  @Value("${application.amqp.queue.test}")
  private String testQueue;

  @Bean("test-queue")
  public Queue createTestQueue() {
    log.info("Creating queue : {}", testQueue);
    return new Queue(testQueue, false);
  }

}