package com.haruhanjan.chattingservice.entity;

import com.haruhanjan.chattingservice.dto.ChatMessageDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private Long id;

    private String roomName;

    @Embedded
    private BaseTimeEntity baseTimeEntity = new BaseTimeEntity();

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Message> room = new ArrayList<>();

    public Long getId() {
        return this.id;
    }
}
