package com.hspedu.qqclient.service;

import com.hspedu.qqclient.utils.StreamUtils;
import com.hspedu.qqcommon.FileMessage;
import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.*;
import java.util.Date;

/**
 * @author Solider
 * @version 1.0
 * 管理客户端与消息相关的方法
 */
public class ManageClientService {

    /**
     * 实现私聊功能
     * @param sender 消息的发送者
     * @param getter 消息的接收者
     * @param content 发送的消息内容
     */
    public void privateChat(String sender, String getter, String content) {
        try {
            Message message = new Message();
            // 设置消息类型、发送方、接收方、内容、时间
            message.setMessageType(MessageType.MESSAGE_COMM_MES);
            message.setSender(sender);
            message.setGetter(getter);
            message.setContent(content);
            message.setSendTime(new Date().toString());
            // 取出对应的socket对象，向服务器发送消息
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void groupChat(String sender, String content) {
        // 设置消息类型、发送方，接收方设为群组、内容，以及时间
        Message message = new Message();
        message.setSender(sender);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        message.setMessageType(MessageType.MESSAGE_ALL_MES);
        // 取出相应的socket对象，向服务器发送消息
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param sender 发送者
     * @param getter 接收者
     * @param senderFilePath 发送者的文件路径
     * @param getterFilePath 接收者的文件路径
     */
    public void sendFile(String sender, String getter, String senderFilePath, String getterFilePath) {
        BufferedInputStream bis = null;
        try {
            FileMessage fileMessage = new FileMessage();
            // 读取需要传送的文件
            bis = new BufferedInputStream(new FileInputStream(senderFilePath));
            byte[] bytes = StreamUtils.streamToByteArray(bis);
            // 发送文件给服务器
            fileMessage.setSender(sender);
            fileMessage.setGetter(getter);
            fileMessage.setGetterPath(getterFilePath);
            fileMessage.setMessageType(MessageType.MESSAGE_FILE_MES);
            fileMessage.setData(bytes);
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
            oos.writeObject(fileMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bis.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
