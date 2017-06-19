package com.hello.spring.guava.service;

import com.google.common.util.concurrent.AbstractIdleService;

/****************************************
 *
 * Created by daipengfei on 2017/6/17.****
 *
 ***************************************/
public class IdleService extends AbstractIdleService {

    @Override
    protected void startUp() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start up");
            }
        }).start();
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    protected void shutDown() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        new IdleService().startUp();
    }

}
