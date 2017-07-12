package com.hello.spring.guava.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/****************************************
 *
 * Created by daipengfei on 2017/6/21.****
 *
 ***************************************/
public class EventBusTestCase {

    private volatile boolean flag = false;

    private int x = 0;

    public void test() throws InterruptedException {
        syncEvent();
//        asynEvent();

        Thread.sleep(Integer.MAX_VALUE);

    }

    private void asynEvent() {
        final ExecutorService executorService = Executors.newFixedThreadPool(100);
        final EventBus eventBus = new AsyncEventBus(executorService);
        eventBus.register(new MultiEventListener());
        for (int i = 1; i <= 2000; i++) {
            eventBus.post(i);
        }
    }

    private void syncEvent() {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        EventBus eventBus = new EventBus("test");
        eventBus.register(new MultiEventListener());
        for (int i = 0; i < 1000; i++) {
            final int j = i;
            executorService.execute(() -> {
                eventBus.post(j);
                eventBus.post(j+1);
            });
        }
    }

}
