package com.hello.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/****************************************
 *
 *
 * Created by daipengfei on 2017/6/14.****
 *
 ***************************************/

@Component
public class Receiver{

    @KafkaListener(topics = {"test1"})
    public void onMessage(ConsumerRecord<String, String> data) {
        System.out.println(data.partition() + " : : : " + Thread.currentThread());
    }
}
