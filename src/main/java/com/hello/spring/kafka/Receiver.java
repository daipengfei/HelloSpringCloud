package com.hello.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

/****************************************
 *
 *
 * Created by daipengfei on 2017/6/14.****
 *
 ***************************************/

@Component
public class Receiver {

    private static int count;

    //    @KafkaListener(topics = {"test"})
    public void onMessage(ConsumerRecord<String, String> data) {
        System.out.println(data.partition() + " :: " + data.value() + Thread.currentThread().getId());
    }

    @KafkaListener(topics = "test-topic")
    public void listenWithHeaders(
            String message, Acknowledgment ack) throws InterruptedException {
        count++;
        System.out.println(message);
        System.out.println(count);
        ack.acknowledge();
//        System.out.println(
//                "Received Message: " + message
//                        + "from partition: " + partition + " :: " + new Date());
    }

    //    @KafkaListener(topics = "test3",group = "foo")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }

    //    @KafkaListener(
//            topicPartitions = @TopicPartition(topic = "test-topic",
//                    partitionOffsets = {
//                            @PartitionOffset(partition = "0", initialOffset = "0",relativeToCurrent = "true"),
//                            @PartitionOffset(partition = "1", initialOffset = "0",relativeToCurrent = "true"),
//                            @PartitionOffset(partition = "2", initialOffset = "0",relativeToCurrent = "true")
//                    }))
    public void listenToParition(
            @Payload Message message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Received Messasge: " + message.getMsg()
                        + "from partition: " + partition);
    }
}
