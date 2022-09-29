package com.haruhanjan.chattingservice.controller;

import com.haruhanjan.chattingservice.dto.ChatMessageDto;
import com.haruhanjan.chattingservice.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatMsgController {

    private final SimpMessageSendingOperations template;
    private final ChatService chatService;

    @MessageMapping("/chat/join")
    public void joinChat(ChatMessageDto dto){
        Long userId = dto.getUserId();
        dto.setContent(userId+"님이 입장하셨습니다.");
        template.convertAndSend("/sub/room/"+dto.getRoomId(), dto);
    }

    @MessageMapping("/chat/message")
    public void requestChat(ChatMessageDto dto){
        chatService.saveMessage(dto);
        template.convertAndSend("/sub/room/"+dto.getRoomId(), dto.getContent());
    }
}
