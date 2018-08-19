package com.poc.springamqp.domain;

import java.util.Map;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

/**
 * @author Luram Archanjo / 20180816
 */
@Component
@Slf4j
public class ConsumerComponent {

  @RabbitListener(queues = {"${application.amqp.queue.test}"})
  public void testQueueConsumer(@NonNull Message message, @Headers Map<String, String> headers) {
    log.info("Consuming {} with headers {}", message, headers);
  }

}