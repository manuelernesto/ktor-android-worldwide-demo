package io.github.manuelernesto.plugins


import io.github.manuelernesto.repository.SpeakerRepository
import io.github.manuelernesto.routes.speakerRoute
import io.github.manuelernesto.service.SpeakerService
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val repository = SpeakerRepository()
    val service = SpeakerService(repository)

    routing {
        speakerRoute(service)
    }
}
