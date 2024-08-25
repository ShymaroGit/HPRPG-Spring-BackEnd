package com.medrano.marino.demoHprpg2022;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/gs-guide-websocket")
            .setAllowedOrigins("http://localhost:4200")
            .setAllowedOrigins("http://192.168.0.100:4200/")
            .withSockJS();// not setAllowedOriginPatterns.withSockJS();// not setAllowedOriginPatterns

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/hprpg");
        config.setApplicationDestinationPrefixes("/app");
    }

}
