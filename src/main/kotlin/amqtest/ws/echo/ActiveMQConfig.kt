package amqtest.ws.echo

import org.apache.activemq.broker.BrokerService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ActiveMQConfig {
    @Bean
    open fun brokerService(): BrokerService {
        val service = BrokerService()
        service.setPersistent(false)
        val connectors = arrayOfNulls<String>(1)
        connectors[0] = "stomp://localhost:61613"
        service.setTransportConnectorURIs(connectors)
        return service
    }
}