package com.haruhanjan.chattingservice.controller;

import com.haruhanjan.chattingservice.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatMsgController {

    private final SimpMessageSendingOperations template;

    @MessageMapping("/chat/join")
    public void joinChat(ChatMessageDto dto){
        Long userId = dto.getUserId();
        dto.setContent(userId+"님이 입장하셨습니다.");
        template.convertAndSend("/room/"+dto.getRoomId(), dto);
    }

    @MessageMapping("/chat/message")
    public void requestChat(ChatMessageDto dto){
        template.convertAndSend("/sub/room/"+dto.getRoomId(), dto);
    }
}
