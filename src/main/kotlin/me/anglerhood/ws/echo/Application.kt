package me.anglerhood.ws.echo

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
open class Application : SpringBootServletInitializer()

fun main(args: Array<String>) {
    SpringApplicationBuilder()
        .sources(Application::class.java)
        .web(WebApplicationType.SERVLET)
        .run(*args)
}

object Starter {
    @JvmStatic fun main(args: Array<String>) {
        SpringApplicationBuilder()
            .sources(Application::class.java)
            .web(WebApplicationType.SERVLET)
            .run(*args)
    }
}