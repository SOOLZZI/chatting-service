package com.haruhanjan.chattingservice.controller;

import com.haruhanjan.chattingservice.dto.ChatMessageDto;
import com.haruhanjan.chattingservice.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<ChatMessageDto> createRoom(){
        ChatMessageDto result = chatService.createRoom();
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
