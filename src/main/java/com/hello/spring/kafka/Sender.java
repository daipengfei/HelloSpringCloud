package com.hello.spring.kafka;

import com.alibaba.fastjson.JSON;
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
    private KafkaTemplate<String, String> kafkaTemplate;

    private void sendMessage() {
        Message m = new Message();
        m.setId(System.currentTimeMillis());
        m.setMsg(UUID.randomUUID().toString());
        m.setSendTime(new Date());
        kafkaTemplate.send("test-topic", JSON.toJSONString(m));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(
                () -> {
                    int i = 0;
                    while (i < 10) {
                        i++;
                        sendMessage();
//                        try {
//                            Thread.sleep(100);
//                        } catch (InterruptedException e) {
//                            Thread.currentThread().interrupt();
//                        }
                    }
                }
        ).start();
    }

}
