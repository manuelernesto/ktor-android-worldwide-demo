package io.github.manuelernesto.routes

import io.github.manuelernesto.service.SpeakerService
import io.github.manuelernesto.model.Speaker
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * @author  Manuel Ernesto (manuelernest0)
 * @date  25/10/22 11:36 AM
 * @version 1.0
 */

fun Route.speakerRoute(service: SpeakerService) {

    route("api/speakers") {
        get() {
            //call.respondText("Hello Android WorldWide")

            call.respond(service.getAll())

//            if (service.getAll().isEmpty())
//                call.respondText("No speaker were found at the database")
//            else
//                call.respond(fakeDB.values)
        }

        post {
            var speaker = call.receive<Speaker>()
            speaker = service.save(speaker)
            call.respond(message = speaker, status = HttpStatusCode.Created)
        }

        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest)
            val speaker = service.getById(id.toInt()) ?: return@get call.respond(HttpStatusCode.NotFound)
            call.respond(speaker)
        }

        delete("{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (service.delete(id.toInt())) call.respond(HttpStatusCode.NoContent)
            else call.respond(HttpStatusCode.NotFound)
        }

        put("{id}") {
            val id = call.parameters["id"] ?: return@put call.respond(HttpStatusCode.BadRequest)
            val speaker = call.receive<Speaker>()

            if (service.update(id.toInt(), speaker) == null) return@put call.respond(HttpStatusCode.NotFound)

            call.respond(message = speaker, status = HttpStatusCode.OK)

        }
    }
}