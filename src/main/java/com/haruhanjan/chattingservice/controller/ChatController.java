package com.haruhanjan.chattingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController("/api/chat")
public class ChatController {

    @GetMapping
    public String requestChat(HttpServletRequest req, HttpServletResponse res){
        return "test";
    }
}
