package com.green.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.*;

@SpringBootApplication
public class ActivemqApplication {

  public static void main(String[] args) {
    SpringApplication.run(ActivemqApplication.class, args);
  }

}
