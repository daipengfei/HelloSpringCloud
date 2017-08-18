package com.hello.spring.entity;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parent {
    private static final ExecutorService executor = Executors.newFixedThreadPool(16);

    private Child child;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public void init() {
        for (int i = 0; i < 16; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("get : " + child.getCaffeine());
                }
            });
        }
    }
}
