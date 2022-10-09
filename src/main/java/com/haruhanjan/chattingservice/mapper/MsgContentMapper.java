package com.haruhanjan.chattingservice.mapper;

import com.haruhanjan.chattingservice.dto.ChatMessageDto;
import org.springframework.stereotype.Component;

@Component
public class MsgContentMapper {

    public String setWelcomeMsg(ChatMessageDto dto){
        return dto.getUserId()+"님께서 채팅에 참여하였습니다.";
    }
    public String setMsgContent(ChatMessageDto dto){
        return dto.getUserId()+"님 : "+dto.getContent();
    }
}
