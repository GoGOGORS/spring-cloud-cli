package com.rx.simple;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Ruixiang
 * Date: 2022:04:04 23:39
 * ProjectName: spring-cloud-cli
 * Description:
 */

@Component
@RabbitListener(queuesToDeclare = @Queue("simple_queue"))
public class TestSimpleQueue {

    @RabbitHandler
    public void simpleQueue(String message){
        System.out.println(message);
    }

}
