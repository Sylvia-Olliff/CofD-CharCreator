package com.sylvantitan.chargen.models.stats

import com.sylvantitan.chargen.models.stats.enums.Skills
import kotlinx.serialization.Serializable

@Serializable
data class SkillStats(
    val charID: Int,
    var skillMap: MutableMap<Skills, Pair<Int,String?>>
) {
    init {
        Skills.values().forEach { skillMap[it] = Pair(0, null) }
    }
}
