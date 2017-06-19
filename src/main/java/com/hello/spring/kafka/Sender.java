package com.hello.spring.kafka;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/****************************************
 *
 * Created by daipengfei on 2017/6/14.****
 *
 ***************************************/

@Component
public class Sender implements InitializingBean {
    @Resource
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage() {
        Message m = new Message();
        m.setId(System.currentTimeMillis());
        m.setMsg(UUID.randomUUID().toString());
        m.setSendTime(new Date());
        kafkaTemplate.send("test1", m);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        int i = 0;
                        while (i < 10) {
                            i++;
                            sendMessage();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
        ).start();
    }

}
