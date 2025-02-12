Routing is just a **plugin**

- It's a plugin that provides a structured routing DSL

We install it by calling install in Application.module() extension function.

```kotlin
install(RoutingRoot) {
  // routing DSL  
}
```

`Routing` is a interface and `RoutingRoot` is a implementation of `Routing` interface.

instead of writing `install(Routing)` we can use `routing` function

```kotlin
routing {
  // routing DSL
}
```
routing is also the extension function on `Application` class.

Routing DSL is a structured way to define routes and their handlers.

```kotlin
routing {
  route("/", HttpMethod.GET) {
    // code to handle GET request to /
  }
}
```

We can also use `get`, `post`, `put`, `delete` functions to define routes.

```kotlin
routing {
  get("/") {
    // code to handle GET request to /
  }
}
```

This is called _Verb, Pattern, Handler_ idiom.

Handler code has access to `call` object which represents the current request.
Using the `call` object we can access request parameters, headers, body, etc.
And we can also set response status, headers, body, etc.
We have access to response methods like `respond`, `respondText`, `respondHtml`, `redirect`, etc.
We can access the query parameters using `call.request.queryParameters["name"]`.

Path Patterns can have placeholders like `/user/{name}`.

### Non-Idomatic way

```kotlin