package com.mansoor.ktor

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
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

        get ("/users/mansoor") {
            call.respondText("Hello, mansoor")
        }

        // This is a route with a parameter
        // We are using the curly braces to define a parameter
        get("/users/{name}") {
            // We can access the parameter using call.parameters["name"]
            // We are using the index notation to access the parameter
            val name = call.parameters["name"]
            call.respondText("Hello, $name")
        }

        // the upper route will work for /users/mansoor but not for /users/mansoor/other
        // This will not work for /users/, Så the empty string is not allowed
        // We can use the following route to allow the empty string

        // The question mark after the parameter name makes the parameter optional
        // This route will work for /users/ and /users/mansoor
        // This will also work for /users, that is without the trailing slash
        get("/users/{name?}") {
            val name = call.parameters["name"] ?: "Mansoor"
            call.respondText("Hello, $name")
        }

        // We can also use the wildcard to match any route
        // Så something like /car/* will match /car/blue
        // But it will not match /car
        get("/car/*") {
            val r = call.request.path()
            call.respondText("Got, $r")
        }

        // the * is a wildcard matches the single value in the path
        // So /car2/blue will not work
        get("/car2/*/color") {
            val r = call.request.path()
            call.respondText("Got, $r")
        }

        // We can also use the tailcard to match any route
        // Så something like /user/{...} will match /user/mansoor, /user/mansoor/other, /user/login/mansoor/another
        // But it will also match /user
        // the tailcard matched all paths of the path at the tail
        get("/cars/{...}") {
            val path = call.request.path()
            call.respondText("Hello, $path")
        }

        // We can use the parameterized tailcard to match any route
        get("/people/{param...}") {
            val params = call.parameters.getAll("param")
            call.respondText("Got, ${params?.joinToString(", ")}")
        }

        // We can also use the query parameters
        // The query parameters are the parameters that are passed in the URL after the question mark
        // So for the URL /query?name=Mansoor&age=25
        // The query parameters are name=Mansoor and age=25
        get("/todo") {
            val id = call.request.queryParameters.get("id")
            call.respondText("Got, $id")
        }
    }
}
