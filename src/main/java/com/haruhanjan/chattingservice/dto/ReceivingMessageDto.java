package com.haruhanjan.chattingservice.dto;

import lombok.Setter;

@Setter
public class ReceivingMessageDto {
    private Long roomId;
    private String content;
}
