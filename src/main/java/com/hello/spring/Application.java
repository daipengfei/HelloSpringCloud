package com.hello.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/****************************************
 *
 * Created by daipengfei on 2017/6/13.****
 *
 ***************************************/

@SpringBootApplication(exclude = {RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class})
@ImportResource("classpath:spring/application-context.xml")
public class Application {

    public static void main(String[] args) throws InterruptedException {
        new SpringApplicationBuilder(Application.class).
                initializers(new Initializer()).
                build().run(args);
        Thread.sleep(Integer.MAX_VALUE);
    }


    private static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            try {
                Resource resources = applicationContext.
                        getResource("config/config.properties");
                Properties properties = new Properties();
                properties.load(resources.getInputStream());
                PropertiesPropertySource source =
                        new PropertiesPropertySource("config", properties);
                applicationContext.getEnvironment().getPropertySources().addLast(source);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
