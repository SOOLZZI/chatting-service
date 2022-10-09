package com.haruhanjan.chattingservice.controller;

import com.haruhanjan.chattingservice.dto.ChatMessageDto;
import com.haruhanjan.chattingservice.mapper.MsgContentMapper;
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
    private final MsgContentMapper msgContentMapper;

    @MessageMapping("/chat/join")
    public void joinChat(ChatMessageDto dto){
        String content = msgContentMapper.setWelcomeMsg(dto);
        template.convertAndSend("/sub/room/"+dto.getRoomId(), content);
    }

    @MessageMapping("/chat/message")
    public void requestChat(ChatMessageDto dto){
        chatService.saveMessage(dto);
        String content = msgContentMapper.setMsgContent(dto);
        template.convertAndSend("/sub/room/"+dto.getRoomId(), content);
    }
}
