package com.well.mqservice.init;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author zwell
 */
@Component
public class Recv {

    private static final String QUEUE_NAME = "hello-mq-2.0";

    @Autowired
    private ConnectionFactory rabbitFactory;

    public String recv() {
        String[] msg = new String[1];
        try {
            Connection connection = rabbitFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            DeliverCallback deliverCallBack = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                msg[0] = message;
                System.out.println(" [y] Received '" + message + "'");
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallBack, consumerTag -> { });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg[0];
    }
}
