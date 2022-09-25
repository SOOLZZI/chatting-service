package com.haruhanjan.chattingservice.controller;

import com.haruhanjan.chattingservice.entity.Room;
import com.haruhanjan.chattingservice.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final RoomRepository repository;
    private final AtomicLong seq = new AtomicLong(0);

    @GetMapping("/rooms")
    public String room(Model model){
        model.addAttribute("rooms", repository.findAll());
        return "/room-list.html";
    }

    @GetMapping("/rooms/{id}")
    public String room(@PathVariable Long id, Model model) {
        Room room = repository.findById(id).orElse(null);
        model.addAttribute("room", room);
        model.addAttribute("member", seq.incrementAndGet()); // 회원 이름 부여
        return "/room.html";
    }
}
