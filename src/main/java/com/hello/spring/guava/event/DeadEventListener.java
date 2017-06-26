package com.hello.spring.guava.event;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/****************************************
 *
 * Created by daipengfei on 2017/6/21.****
 *
 ***************************************/
public class DeadEventListener {

    private boolean notDelivered = false;

    @Subscribe
    public void listen(DeadEvent event) {
        notDelivered = true;
        System.out.println(Thread.currentThread().getName() + " : " + notDelivered
        + " -- event : " + event);
    }


    public boolean isNotDelivered() {
        return notDelivered;
    }
}
