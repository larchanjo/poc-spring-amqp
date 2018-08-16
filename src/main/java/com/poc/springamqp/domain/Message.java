package com.poc.springamqp.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Luram Archanjo / 20180816
 */
@Builder
@Data
@AllArgsConstructor
public class Message implements Serializable {

  private final String content = UUID.randomUUID().toString();
  private final LocalDateTime createDate = LocalDateTime.now();

}