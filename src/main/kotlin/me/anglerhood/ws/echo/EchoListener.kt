package me.anglerhood.ws.echo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service

@Controller
class EchoListener {
    @Autowired
    lateinit var echoService: EchoService

    @MessageMapping("/incoming")
    fun listen(message: Message) {
        echoService.echo(message)
    }
}

@Service
class EchoService {
    @Autowired
    lateinit var echoSender: EchoSender

    fun echo(message: Message) {
        echoSender.sendEcho(Message("Received message: ${message.data}"))
    }
}

@Service
class EchoSender {
    @Autowired
    lateinit var messagingTemplate: SimpMessagingTemplate

    fun sendEcho(message: Message) {
        messagingTemplate.convertAndSend("/topic/messages", message)
    }
}


