package me.anglerhood.ws.echo

import Message
import org.springframework.stereotype.Service

@Service
class EchoService {
    fun echo(message: String?): Message {
        return Message(message ?: "")
    }
}