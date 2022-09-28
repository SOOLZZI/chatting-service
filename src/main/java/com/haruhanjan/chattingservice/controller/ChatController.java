package com.haruhanjan.chattingservice.controller;

import com.haruhanjan.chattingservice.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {
    private final ChatService chatService;

    @GetMapping("/room")
    public String room(Model model){
        return "/room";
    }

    @GetMapping("/room/{roomId}")
    public String enterRoom(@PathVariable Long roomId){
        return "/room-detail";
    }
}
