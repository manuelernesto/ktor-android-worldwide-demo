package io.github.manuelernesto.repository

import io.github.manuelernesto.Speaker
import io.github.manuelernesto.datasource.db
import io.github.manuelernesto.datasource.getId

/**
 * @author  Manuel Ernesto (manuelernest0)
 * @date  25/10/22 11:34 AM
 * @version 1.0
 */

class SpeakerRepository() {

    fun get() = db.values
    fun get(id: Int): Speaker? = db[id]
    fun save(speaker: Speaker): Speaker {
        speaker.id = getId()
        db[getId()] = speaker
        return speaker
    }

    fun delete(id: Int) = db.remove(id)

    fun update(id: Int, speaker: Speaker): Speaker? = db.replace(id, speaker)
}