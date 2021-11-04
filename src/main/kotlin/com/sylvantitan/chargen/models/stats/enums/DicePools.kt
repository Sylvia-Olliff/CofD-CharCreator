package com.sylvantitan.chargen.models.stats.enums

import com.sylvantitan.chargen.models.stats.CoreStats
import com.sylvantitan.chargen.models.stats.SkillStats

enum class DicePools(private val resolveFun: (stats: CoreStats, skills: SkillStats) -> Int) {
    DEFENSE({ stats, skills ->
        if (stats.Dexterity < stats.Wits) {
            stats.Dexterity + skills.skillMap[Skills.ATHLETICS]!!.first
        } else {
            stats.Wits + skills.skillMap[Skills.ATHLETICS]!!.first
        }
    }),
    HEALTH({ stats, skills ->  
        stats.Stamina + stats.Size
    }),
    WILLPOWER({ stats, skills ->  
        stats.Resolve + stats.Composure
    }),
    INITIATIVE({ stats, skills ->
        stats.Dexterity + stats.Composure
    }),
    SPEED({ stats, skills ->
        stats.Strength + stats.Dexterity + stats.SpeciesFactor
    }),
    PERCEPTION({ stats, skills ->
        stats.Wits + stats.Composure
    });

    fun size(stats: CoreStats, skills: SkillStats): Int {
        return this.resolveFun(stats, skills)
    }
}