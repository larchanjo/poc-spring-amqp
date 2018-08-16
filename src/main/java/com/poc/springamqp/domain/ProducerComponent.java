package com.poc.springamqp.domain;

import com.poc.springamqp.domain.Message;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Luram Archanjo / 20180816
 */
@Component
@Slf4j
public class ProducerComponent {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Value("${application.amqp.queue.test}")
  private String testQueue;

  @PostConstruct
  private void producerMessage() {
    for (int counter = 1; counter <= 3; counter++) {
      Message message = new Message();

      log.info("Adding {} to {}", message, testQueue);
      rabbitTemplate.convertAndSend(testQueue, message);
    }
  }

}