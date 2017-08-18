package com.hello.spring.entity;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * Created by daipengfei
 * on 2017/8/18.
 */
public class Child {

    private String name;

    private int id;

    private LoadingCache<String, String> caffeine;

    public void init() {
        name = "hello";
        caffeine =
                Caffeine.newBuilder()
                        .maximumSize(1000)
                        .expireAfterWrite(10, TimeUnit.MINUTES)
                        .build(key -> key);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LoadingCache<String, String> getCaffeine() {
        return caffeine;
    }
}
