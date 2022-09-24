package com.example.chattingservice.dto;

import lombok.Setter;

@Setter
public class ReceivingMessageDto {
    private Long roomId;
    private String content;
}
