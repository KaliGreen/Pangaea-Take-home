package com.green.activemq;

import com.green.activemq.dto.response.SubscriberPayload;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;
import javax.servlet.http.Part;

/**
 * @author green
 * @version 1.0
 * @project 24/12/2020 17:16
 */
@Service
@Slf4j
public class MessageService {

  @Autowired
  JmsTemplate jmsTemplate;

  public void send(String topic, Particulars particulars) {
    SubscriberPayload subscriberPayload = new SubscriberPayload();
    subscriberPayload.setData(particulars);
    subscriberPayload.setTopic(topic);
    jmsTemplate.send(topic, session -> session.createObjectMessage(subscriberPayload.toString()));
  }
}
