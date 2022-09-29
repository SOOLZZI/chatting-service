package com.haruhanjan.chattingservice.service;

import com.haruhanjan.chattingservice.dto.ChatMessageDto;
import com.haruhanjan.chattingservice.entity.Message;
import com.haruhanjan.chattingservice.repository.MessageRepository;
import com.haruhanjan.chattingservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;

    public void saveMessage(ChatMessageDto dto) {
        Message entity = dto.toEntity();
    }

    public ChatMessageDto createRoom() {

    }
}
