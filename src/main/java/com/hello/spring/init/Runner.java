package com.hello.spring.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/****************************************
 *
 * Created by daipengfei on 2017/6/24.****
 *
 ***************************************/

@ConfigurationProperties(prefix = "hello.spring")
@Component
public class Runner implements ApplicationRunner {
    private String configKey;

    private String loadKey;

    private String key;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(configKey + " -- " + loadKey + " -- " + key);
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getLoadKey() {
        return loadKey;
    }

    public void setLoadKey(String loadKey) {
        this.loadKey = loadKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
