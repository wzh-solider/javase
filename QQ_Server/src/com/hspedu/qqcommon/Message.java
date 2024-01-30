package com.hspedu.qqcommon;

import java.io.Serializable;

/**
 * @author Solider
 * @version 1.0
 * 由客户端向服务端发送的信息
 */
public class Message implements Serializable {

    // 提高版本兼容性
    private static final long serialVersionUID = 1L;
    private String sender; // 发送者
    private String getter; // 接收者
    private String content; // 发送的内容
    private String sendTime; // 发送的时间
    private String messageType; // 消息的类型

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
