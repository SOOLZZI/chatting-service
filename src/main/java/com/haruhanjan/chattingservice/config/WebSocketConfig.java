package com.haruhanjan.chattingservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@Slf4j
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${front.base_url}")
    private String frontURL;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // handshaking 담당                         CORS 설정 ─┐
        registry.addEndpoint("/ws/chat").setAllowedOriginPatterns("*");//.withSockJS();
        registry.addEndpoint("/ws-chat").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub"); // 1:N, 1:1
        registry.setApplicationDestinationPrefixes("/pub"); // client의 SEND 요청 처리
    }

}
