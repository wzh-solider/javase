package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.FileMessage;
import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author Solider
 * @version 1.0
 * 用来保持数据通道的连接
 */
public class ClientConnectServerThread extends Thread {
    // 持有socket对象
    private Socket socket;

    // socket初始化
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    // 通过开启这个线程服务，保持客户端和服务端的连接
    @Override
    public void run() {
        while(true) {
            System.out.println("客户端线程，等待读取服务端的Message对象");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // 如果服务端没有发送message对象，会阻塞在readObject()这里
                Message message = (Message) ois.readObject();
                // 接收返回的对象
                if (message.getMessageType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    String[] s = message.getContent().split(" ");
                    for (String value : s) {
                        System.out.println(value);
                    }
                } else if (message.getMessageType().equals(MessageType.MESSAGE_COMM_MES)){

                    System.out.println("\n" + message.getSendTime() +
                                        "\n" + message.getSender() + "->" + message.getGetter() + "：" + message.getContent());

                } else if (message.getMessageType().equals(MessageType.MESSAGE_ALL_MES)) {

                    System.out.println("\n" + message.getSendTime());
                    System.out.println(message.getSender() + "对大家说" + message.getContent());

                } else if (message.getMessageType().equals(MessageType.MESSAGE_FILE_MES)) {

                    FileMessage fileMessage = (FileMessage) message;
                    System.out.println("\n" + message.getSender() + "给" + message.getGetter() + "发送文件，写入" + fileMessage.getGetterPath());
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileMessage.getGetterPath()));
                    bos.write(fileMessage.getData());
                    bos.close();
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

}
