package com.sylvantitan.chargen.models.stats

import kotlinx.serialization.Serializable

@Serializable
data class Merit(
    val id: Int,
    val name: String,
    val pointMin: Int,
    val pointMax: Int,
    val description: String,
    val modifiers: List<Modification>?
) {
    companion object {
        fun deserialize(input: String): Merit {
            TODO("Not implemented yet")
        }
    }

    fun serialize(): String {
        TODO("Not implemented yet")
    }
}
