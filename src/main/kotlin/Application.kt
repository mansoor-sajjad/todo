package com.mansoor.ktor

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

// Extension function on class Application.
fun Application.module() {

    val port = environment.config.propertyOrNull("ktor.deployment.port")?.getString() ?: "9999"

    configureMonitoring()
    configureRouting()
}
