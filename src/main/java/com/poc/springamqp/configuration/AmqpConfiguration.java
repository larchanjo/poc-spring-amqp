package com.poc.springamqp.configuration;

import java.util.HashMap;
import java.util.Map;
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

  @Value("${application.amqp.queue.test-dlq}")
  private String testDlqQueue;

  @Bean("test-queue")
  public Queue createTestQueue() {
    log.info("Creating queue : {}", testQueue);

    Map<String, Object> arguments = new HashMap<>();
    arguments.put("x-dead-letter-exchange", "");
    arguments.put("x-dead-letter-routing-key", testDlqQueue);

    return new Queue(testQueue, false, false, false, arguments);
  }

  @Bean("test-dlq-queue")
  public Queue createTestDlqQueue() {
    log.info("Creating dead letter queue : {}", testDlqQueue);
    return new Queue(testDlqQueue);
  }

}