package com.haruhanjan.chattingservice.service;

import com.haruhanjan.chattingservice.dto.ChatMessageDto;
import com.haruhanjan.chattingservice.entity.Message;
import com.haruhanjan.chattingservice.entity.Room;
import com.haruhanjan.chattingservice.repository.MessageRepository;
import com.haruhanjan.chattingservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;

    public void saveMessage(ChatMessageDto dto) {
        Message entity = dto.toEntity();
    }

    @Transactional
    public Long createChatRoom() {
        Room newRoom = new Room();
        Room saved = roomRepository.save(newRoom);
        return saved.getId();

    }
}
