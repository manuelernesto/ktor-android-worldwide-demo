package io.github.manuelernesto.model

import kotlinx.serialization.Serializable

/**
 * @author  Manuel Ernesto (manuelernest0)
 * @date  25/10/22 11:35 AM
 * @version 1.0
 */

@Serializable
data class Speaker(var id: Int? = null, val name: String, val country: String)
