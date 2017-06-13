package com.hello.spring.kafka;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/****************************************
 *
 * Created by daipengfei on 2017/6/14.****
 *
 ***************************************/

@Component
public class Sender implements InitializingBean{
    @Resource
    private KafkaTemplate<Object, String> kafkaTemplate;

    public void sendMessage(){
        Message m = new Message();
        m.setId(System.currentTimeMillis());
        m.setMsg(UUID.randomUUID().toString());
        m.setSendTime(new Date());
        kafkaTemplate.send("test1" ,JSON.toJSONString(m));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(true){
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
