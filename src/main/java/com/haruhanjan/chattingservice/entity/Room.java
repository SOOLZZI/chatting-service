package com.haruhanjan.chattingservice.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private Long id;

    private Long fromUser;
    private Long toUser;

    @Embedded
    private BaseTimeEntity baseTimeEntity = new BaseTimeEntity();

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Message> room = new ArrayList<>();
}
