package io.github.manuelernesto.plugins


import io.github.manuelernesto.Repository
import io.github.manuelernesto.service.SpeakerService
import io.github.manuelernesto.speakerRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val repository = Repository()
    val service = SpeakerService(repository)

    routing {
        speakerRoute(service)
    }
}
