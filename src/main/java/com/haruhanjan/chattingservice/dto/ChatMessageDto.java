package com.haruhanjan.chattingservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatMessageDto {
    private Long roomId;
    private Long userId;
    private String content;
}
