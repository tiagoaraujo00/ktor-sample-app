package tiagoaraujo00.dev.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.*

fun Application.configureRouting() {
    routing {
        staticResources("/content", "mycontent")
        get("/") {
            call.respondText("Hello World!")
        }
        get("/test1") {
            val text = "<h1>Hello from Ktor</h1>"
            val type = ContentType.parse("text/html")
            call.respondText(text, type)
        }
    }
}
