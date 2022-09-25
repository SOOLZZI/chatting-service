package com.haruhanjan.chattingservice.repository;

import com.haruhanjan.chattingservice.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
