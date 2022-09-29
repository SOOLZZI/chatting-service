package com.haruhanjan.chattingservice.dto;

import com.haruhanjan.chattingservice.entity.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatMessageDto {
    private Long roomId;
    private Long userId;
    private String content;

    public Message toEntity() {
        return Message.builder()
                .content(content)
                .userId(userId)
                .build();
    }
}
