package com.poc.springamqp.domain;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Luram Archanjo / 20180816
 */
@Component
@Slf4j
public class ConsumerComponent {

  @RabbitListener(id = "test-queue-consumer", queues = { "${application.amqp.queue.test}"})
  public void testQueueConsumer(@NonNull Message message) {
    log.info("Consuming {}", message);
  }

}
