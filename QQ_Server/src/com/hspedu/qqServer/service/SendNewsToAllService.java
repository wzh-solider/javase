package com.hspedu.qqServer.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;

/**
 * @author Solider
 * @version 1.0
 * 服务器向所有用户发送推送消息
 */
public class SendNewsToAllService implements Runnable {

    @Override
    public void run() {
        while (true) {
            // 输入的发送内容
            System.out.print("请输入需要推送的内容(exit<退出>)：");
            String content = Utility.readString(100);
            if (content.equals("exit")) {
                break;
            }
            Message message = new Message();
            message.setSender("服务器");
            message.setMessageType(MessageType.MESSAGE_ALL_MES);
            message.setSendTime(new Date().toString());
            message.setContent(content);
            // 向所有在线用户推送新闻消息
            HashMap<String, ServerConnectClientThread> hashMap = ManageServerConnectClientThread.getHashMap();
            Iterator<String> it = hashMap.keySet().iterator();
            try {
                while (it.hasNext()) {
                    String key = it.next();
                    Socket socket = hashMap.get(key).getSocket();
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
