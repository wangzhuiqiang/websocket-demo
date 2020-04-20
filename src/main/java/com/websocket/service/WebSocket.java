package com.websocket.service;



import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * WebSocket
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocket {

    @OnOpen
    public void onOpen() {
        System.out.println("连接建立");
    }

    @OnClose
    public void onClose() {
        System.out.println("连接关闭");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        try {

            System.out.println("接收到消息：" + message);
            Thread.sleep(2000);
            System.out.println("发送消息给页面：HelloWord");

            session.getBasicRemote().sendText("HelloWord"); //发送消息
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throw new IllegalArgumentException(throwable);
    }

    public WebSocket() {
        System.out.println("==WebSocket==");
    }


}
