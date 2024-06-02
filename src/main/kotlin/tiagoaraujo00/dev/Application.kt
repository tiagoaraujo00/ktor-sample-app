package tiagoaraujo00.dev

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import tiagoaraujo00.dev.plugins.*

fun main() {
    embeddedServer(
        Netty,
        port = 9292,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureSecurity()
    configureSerialization()
    configureDatabases()
    configureHTTP()
    configureTemplating()
    configureRouting()
}
