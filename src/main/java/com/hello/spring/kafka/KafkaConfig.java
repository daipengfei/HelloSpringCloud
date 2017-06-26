package com.hello.spring.kafka;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.io.Closeable;

/****************************************
 *
 * Created by daipengfei on 2017/6/14.****
 *
 ***************************************/

//@Configuration
//@EnableKafka
public class KafkaConfig {

    private KafkaProperties kafkaProperties;

    public KafkaConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    //    @Bean
    public ConsumerFactory<String, Message> kafkaConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(),
                new StringDeserializer(),
                new JsonDeserializer<>(Message.class));
    }


    //    @Bean
    public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Message> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaConsumerFactory());
        factory.setBatchListener(true);
        factory.setRecordFilterStrategy(
                record -> record.value().getMsg().contains("14974625768"));
        return factory;
    }

    //    @Bean
    public TestBean testBean() {
        return new TestBean();
    }

    public static class TestBean implements Closeable {
        public void close() {
            System.out.println("close test bean!!!!!");
        }
    }

}
