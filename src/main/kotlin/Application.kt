package com.mansoor.ktor

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

// Extension function on class Application.
// To create the Application i Ktor we add this extension function to the Application class.
fun Application.module() {

    configureMonitoring()
    configureRouting()
}
