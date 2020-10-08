package me.anglerhood.ws.echo

import org.apache.activemq.broker.BrokerService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms

@Configuration
@EnableJms
open class ActiveMQConfig {
    @Bean
    open fun broker(): BrokerService? {
        val broker = BrokerService()
        broker.setPersistent(false)
        broker.setUseJmx(true)
        broker.transportConnectorURIs = arrayOf("stomp://localhost:61613")
        return broker
    }
}