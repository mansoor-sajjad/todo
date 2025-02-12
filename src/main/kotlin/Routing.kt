package com.mansoor.ktor

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        route("/", HttpMethod.Get) {
            handle {
                call.respondText("Hello World!")
            }
        }

        // Following is the same as above but using get instead of route and handle
        // But it is the recommended way to do it
        // get has access to the call object same as handle above
        get("/users") {
            call.respondText("Got users")
        }
    }
}
