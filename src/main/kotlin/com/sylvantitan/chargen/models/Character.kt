package com.sylvantitan.chargen.models

import com.sylvantitan.chargen.models.stats.CoreStats
import com.sylvantitan.chargen.models.stats.Modification
import com.sylvantitan.chargen.models.stats.SkillStats
import com.sylvantitan.chargen.models.stats.enums.Attributes
import com.sylvantitan.chargen.models.stats.enums.DicePools
import com.sylvantitan.chargen.models.stats.enums.ModTypes
import com.sylvantitan.chargen.models.stats.enums.Skills
import kotlinx.serialization.Serializable

@Serializable
open class Character(
    val ID: Int,
    var Name: String,
    var Player: String,
    var Chronicle: String,
    protected val charID: Int,
    protected val coreStats: CoreStats,
    protected val skillStats: SkillStats,
) {

    private var defenseBonus: Int = 0
    open var Defense: Int
        protected set(value) { defenseBonus += value }
        get() = DicePools.DEFENSE.size(coreStats, skillStats) + defenseBonus

    private var willpowerBonus: Int = 0
    open var Willpower: Int
        protected set(value) { willpowerBonus += value }
        get() = DicePools.WILLPOWER.size(coreStats, skillStats) + willpowerBonus

    private var speedBonus: Int = 0
    open var Speed: Int
        protected set(value) { speedBonus += value }
        get() = DicePools.SPEED.size(coreStats, skillStats) + speedBonus

    private var healthBonus: Int = 0
    open var Health: Int
        protected set(value) { healthBonus += value }
        get() = DicePools.HEALTH.size(coreStats, skillStats) + healthBonus

    private var initiativeBonus: Int = 0
    open var Initiative: Int
        protected set(value) { initiativeBonus += value }
        get() = DicePools.INITIATIVE.size(coreStats, skillStats) + initiativeBonus

    private var perceptionBonus: Int = 0
    open var Perception: Int
        protected set(value) { perceptionBonus += value }
        get() = DicePools.PERCEPTION.size(coreStats, skillStats) + perceptionBonus

    protected open fun modifyAttribute(att: Attributes, value: Int) {
        when (att) {
            Attributes.INTELLIGENCE -> coreStats.Intelligence += value
            Attributes.WITS -> coreStats.Wits += value
            Attributes.RESOLVE -> coreStats.Resolve += value
            Attributes.STRENGTH -> coreStats.Strength += value
            Attributes.DEXTERITY -> coreStats.Dexterity += value
            Attributes.STAMINA -> coreStats.Stamina += value
            Attributes.PRESENCE -> coreStats.Presence += value
            Attributes.MANIPULATION -> coreStats.Manipulation += value
            Attributes.COMPOSURE -> coreStats.Composure += value
            Attributes.SIZE -> coreStats.Size += value
            Attributes.SPECIES_FACTOR -> coreStats.SpeciesFactor += value
        }
    }

    protected open fun modifySkills(skill: Skills, value: Int) {
        skillStats.skillMap[skill] = Pair(skillStats.skillMap[skill]?.first?.plus(value) ?: value, skillStats.skillMap[skill]?.second)
    }

    protected open fun modifySkills(skill: Skills, value: String) {
        skillStats.skillMap[skill] = Pair(skillStats.skillMap[skill]?.first ?: 1, value)
    }

    protected open fun modifyDicePools(pool: DicePools, value: Int) {
        when (pool) {
            DicePools.DEFENSE -> Defense = value
            DicePools.HEALTH -> Health = value
            DicePools.WILLPOWER -> Willpower = value
            DicePools.INITIATIVE -> Initiative = value
            DicePools.SPEED -> Speed = value
            DicePools.PERCEPTION -> Perception = value
        }
    }

    protected open fun processModifiers(mods: List<Modification>) {
        mods.forEach {
            //if (!modifications.contains(it)) modifications.add(it)

            when (it.type) {
                ModTypes.ATTRIBUTE -> modifyAttribute(it.attribute!!, it.value as Int)
                ModTypes.SKILL -> modifySkills(it.skill!!, it.value as Int)
                ModTypes.SKILL_SPECIALTY -> modifySkills(it.skill!!, it.value as String)
                ModTypes.DICE_POOL -> modifyDicePools(it.dicePool!!, it.value as Int)
                else -> null
            }
        }
    }
}