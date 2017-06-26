package com.hello.spring.guava.event;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/****************************************
 *
 * Created by daipengfei on 2017/6/21.****
 *
 ***************************************/
public class MultiEventListener {
    private static Integer lastInteger = 0;
    private Long lastLong;

    public Number getLastNumber() {
        return lastNumber;
    }

    private Number lastNumber;

    @Subscribe
    @AllowConcurrentEvents
    public void listenInteger(Integer event) throws InterruptedException {
        lastInteger++;
        System.out.println(this + " -- " + Thread.currentThread().getName() + " --- liten int message ： " + lastInteger);
    }

    //    @Subscribe
    public void listenNumber(Number event) {
        lastNumber = event;
        System.out.println(Thread.currentThread().getName() + " --- liten number message ： " + lastNumber);
    }

    @Subscribe
    public void listenLong(Long event) {
        lastLong = event;
        System.out.println(Thread.currentThread().getName() + " --- liten long message ： " + lastLong);
    }

    public Integer getLastInteger() {
        return lastInteger;
    }

    public Long getLastLong() {
        return lastLong;
    }
}
