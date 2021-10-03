package com.green.activemq.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author green
 * @version 1.0
 * @project 03/10/2021 10:37
 */
@Data
@AllArgsConstructor
public class SubscriptionResponse {
  private String url;
  private String topic;
}
