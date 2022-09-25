package com.haruhanjan.chattingservice.controller;

import com.haruhanjan.chattingservice.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Profile("stomp")
@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/chat/join")
    public void joinChat(ChatMessageDto dto){
        Long userId = dto.getUserId();
        dto.setContent(userId+"님이 입장하셨습니다.");
        template.convertAndSend("/chat/room/"+dto.getRoomId(), dto);
    }

    @MessageMapping("/chat/message")
    public void requestChat(ChatMessageDto dto){
        template.convertAndSend("/chat/room/"+dto.getRoomId(), dto);
    }
}
