package com.mansoor.ktor

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

// Extension function on class Application.
// To create the Application i Ktor we add this extension function to the Application class.
fun Application.module() {

    configureMonitoring()
//    configureRouting()
    // Lets do routing the hard way

    install(RoutingRoot) {
        route("/", HttpMethod.Get) {
            handle {
                call.respondText("Hello from routing")
            }
        }
    }
}
