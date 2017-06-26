package com.hello.spring.guava.event;

/****************************************
 *
 * Created by daipengfei on 2017/6/21.****
 *
 ***************************************/

class TestEvent {
    private final int message;

    TestEvent(int message) {
        this.message = message;
    }

    int getMessage() {
        return message;
    }
}
