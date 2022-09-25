package com.haruhanjan.chattingservice.config;

import com.haruhanjan.chattingservice.controller.ChatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Profile("stomp")
@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final ChatHandler chatHandler;

    @Value("${front.base_url}")
    private String frontURL;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // handshaking 담당
        registry.addEndpoint("/ws/chat").setAllowedOrigins(frontURL).withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic","/queue"); // 1:N, 1:1
        registry.setApplicationDestinationPrefixes("/app"); // client의 SEND 요청 처리
    }

}
