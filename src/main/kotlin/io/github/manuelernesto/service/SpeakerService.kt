package io.github.manuelernesto.service

import io.github.manuelernesto.model.Speaker
import io.github.manuelernesto.repository.SpeakerRepository

/**
 * @author  Manuel Ernesto (manuelernest0)
 * @date  25/10/22 11:34 AM
 * @version 1.0
 */

class SpeakerService(private val repository: SpeakerRepository) {
    fun save(speaker: Speaker): Speaker = repository.save(speaker)

    fun getAll() = repository.get()

    fun getById(id: Int) = repository.get(id)

    fun delete(id: Int) = repository.delete(id) != null

    fun update(id: Int, speaker: Speaker): Speaker? {
        speaker.id = id
        return repository.update(id, speaker)
    }
}
