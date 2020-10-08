package me.anglerhood.ws.echo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.*


@Configuration
@EnableWebSocketMessageBroker
open class BrokerConfig: WebSocketMessageBrokerConfigurer {
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS()
    }

    override fun configureMessageBroker(config: MessageBrokerRegistry) {
        config.enableStompBrokerRelay("/topic")
            .setRelayHost("localhost")
            .setRelayPort(61613)
            .setClientLogin("guest")
            .setClientPasscode("guest")
        config.setApplicationDestinationPrefixes("/app")
    }
}

@Configuration
@EnableWebSocket
open class WebsocketConfig: WebSocketConfigurer {
    @Autowired
    lateinit var echoHandler: EchoHandler

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(echoHandler, "/echo")
    }
}