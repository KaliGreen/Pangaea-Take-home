package com.green.activemq;

import lombok.AllArgsConstructor;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

/**
 * @author green
 * @version 1.0
 * @project 24/12/2020 17:15
 */
@RestController
public class ActiveController {


  @Value("${spring.activemq.broker-url}")
  private String brokerUrl;

  @Value("${spring.activemq.user}")
  private String username;

  @Value("${spring.activemq.password}")
  private String password;

  @PostMapping("/publish/{topic}")
  public ResponseEntity<?> createTopicAndPublish(@RequestBody Particulars particulars, @PathVariable String topic) {
    ConnectionFactory factory = new ActiveMQConnectionFactory(
      username, password, brokerUrl
    );

    try {
      Connection connection = factory.createConnection();
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      Destination destination = session.createTopic(topic);

      MessageProducer messageProducer = session.createProducer(destination);
      TextMessage textMessage = session.createTextMessage(particulars.getMsg());
      messageProducer.send(textMessage);
      session.close();
      connection.close();
      System.out.println("sending.........");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new ResponseEntity<>(particulars.getMsg(), HttpStatus.OK);
  }
}
