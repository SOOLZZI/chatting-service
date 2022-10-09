package com.haruhanjan.chattingservice.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="message_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private Room room;

    private String content;
    private Long userId;

    @Embedded
    private BaseTimeEntity baseTimeEntity = new BaseTimeEntity();

    @Builder
    public Message(Room room, String content, Long userId) {
        this.room = room;
        this.content = content;
        this.userId = userId;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
