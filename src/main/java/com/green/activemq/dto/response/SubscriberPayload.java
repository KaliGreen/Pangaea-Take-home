package com.green.activemq.dto.response;

import lombok.Data;

/**
 * @author green
 * @version 1.0
 * @project 03/10/2021 13:59
 */
@Data
public class SubscriberPayload {
  private String topic;
  private Object data;
}
