package com.hello.spring.kafka;

import java.util.Date;

/****************************************
 *
 * Created by daipengfei on 2017/6/14.****
 *
 ***************************************/
public class Message {

    private Long id;

    private String msg;

    private Date sendTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}