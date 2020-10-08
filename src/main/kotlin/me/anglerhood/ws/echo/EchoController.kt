package me.anglerhood.ws.echo

import Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.annotation.SubscribeMapping
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler


//@RestController
//class EchoController {
//
//    @Autowired
//    lateinit var echoService: EchoService;
//
//    @MessageMapping("/hello")
//    @SendTo("/topic/greeting")
//    fun echo():Message {
//        return echoService.echo("yo!")
//    }
//
//}

@Component
class EchoHandler: TextWebSocketHandler() {
    @Autowired
    lateinit var echoService: EchoService;

    @Autowired
    lateinit var stompClient: StompClient

    override fun handleTextMessage(session: WebSocketSession?, message: TextMessage?) {
        val reply  = echoService.echo(message?.payload.toString())
        stompClient.sendToGreetings(Message(reply.message))
        session?.sendMessage(TextMessage(reply.message))
    }
}

@Controller
class StompClient {
    @MessageMapping("/hello")
    fun receiveMessage(message: Message) {
    }

    @SendTo("/topic/greetings")
    fun sendToGreetings(message: Message): Message {
        return message
    }

    @Scheduled(fixedRate = 1000)
    @SendTo("/topic/repeater")
    fun repeater(): String {
        return "ping"
    }
}