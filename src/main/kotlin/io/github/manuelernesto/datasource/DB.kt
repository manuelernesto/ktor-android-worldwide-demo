package io.github.manuelernesto.datasource

import io.github.manuelernesto.Speaker

/**
 * @author  Manuel Ernesto (manuelernest0)
 * @date  25/10/22 11:33 AM
 * @version 1.0
 */


val db = mutableMapOf<Int, Speaker>()
fun getId(): Int {
    if (db.isEmpty()) return 1
    return db.size + 1
}
