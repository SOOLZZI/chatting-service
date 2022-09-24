package com.example.chattingservice.service;

import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@ServerEndpoint(value="/chat")
public class WebSocketChat {
    // 클라이언트 세션 관련 정보
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(String msg, Session session){

    }

    @OnOpen
    public void onOpen(Session s){

    }

    @OnClose
    public void onClose(Session s){

    }
}
