package com.sylvantitan.chargen.models.stats

import com.sylvantitan.chargen.models.stats.enums.Attributes
import com.sylvantitan.chargen.models.stats.enums.DicePools
import com.sylvantitan.chargen.models.stats.enums.ModTypes
import com.sylvantitan.chargen.models.stats.enums.Skills
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

@Serializable
data class Modification(
    val id: Int,
    val type: ModTypes,
    val attribute: Attributes?,
    val skill: Skills?,
    val merit: Merit?,
//    val favor: Favor?,
    val dicePool: DicePools?,
    @Contextual
    val value: Any?
)
