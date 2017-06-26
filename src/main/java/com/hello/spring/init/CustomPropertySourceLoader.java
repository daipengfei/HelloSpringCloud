package com.hello.spring.init;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/****************************************
 *
 * Created by daipengfei on 2017/6/24.****
 *
 ***************************************/

public class CustomPropertySourceLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"jsonp"};
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        Properties properties = new Properties();
        properties.load(resource.getInputStream());
        return new PropertiesPropertySource(name,properties);
    }
}
