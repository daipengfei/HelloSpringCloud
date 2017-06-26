package com.hello.spring.guava.event;

import com.google.common.eventbus.Subscribe;

/****************************************
 *
 * Created by daipengfei on 2017/6/21.****
 *
 ***************************************/
public class EventListener {
    private int lastMessage = 0;

    @Subscribe
    public void listen(TestEvent event) {
        lastMessage = event.getMessage();
        System.out.println(Thread.currentThread().getName() + " --- liten message ： " + lastMessage);
    }

    public int getLastMessage() {
        return lastMessage;
    }
}
