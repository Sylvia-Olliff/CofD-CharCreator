package com.sylvantitan.chargen.models.stats

import com.sylvantitan.chargen.models.stats.enums.AttributeMainCategory
import com.sylvantitan.chargen.models.stats.enums.AttributeSideCategory
import com.sylvantitan.chargen.models.stats.enums.Attributes
import kotlinx.serialization.Serializable

@Serializable
data class CoreStats(
    val charID: Int,
    var Intelligence: Int,
    var Wits: Int,
    var Resolve: Int,
    var Strength: Int,
    var Dexterity: Int,
    var Stamina: Int,
    var Presence: Int,
    var Manipulation: Int,
    var Composure: Int,
    var Size: Int,
    var SpeciesFactor: Int
) {
    fun getPowerTotal(): Int {
        return calcTotal(Attributes.getAttributeSet(AttributeSideCategory.POWER))
    }

    fun getFinesseTotal(): Int {
        return calcTotal(Attributes.getAttributeSet(AttributeSideCategory.FINESSE))
    }

    fun getResistanceTotal(): Int {
        return calcTotal(Attributes.getAttributeSet(AttributeSideCategory.RESISTANCE))
    }

    fun getPhysicalTotal(): Int {
        return calcTotal(Attributes.getAttributeSet(AttributeMainCategory.PHYSICAL))
    }

    fun getMentalTotal(): Int {
        return calcTotal(Attributes.getAttributeSet(AttributeMainCategory.MENTAL))
    }

    fun getSocialTotal(): Int {
        return calcTotal(Attributes.getAttributeSet(AttributeMainCategory.SOCIAL))
    }

    fun getSpeed(): Int {
        return calcTotal(arrayOf(Attributes.SPECIES_FACTOR, Attributes.DEXTERITY, Attributes.STRENGTH))
    }

    private fun calcTotal(attributes: Array<Attributes>): Int {
        var total = 0
        attributes.forEach {
            total += when (it) {
                Attributes.INTELLIGENCE -> Intelligence
                Attributes.WITS -> Wits
                Attributes.RESOLVE -> Resolve
                Attributes.STRENGTH -> Strength
                Attributes.DEXTERITY -> Dexterity
                Attributes.STAMINA -> Stamina
                Attributes.PRESENCE -> Presence
                Attributes.MANIPULATION -> Manipulation
                Attributes.COMPOSURE -> Composure
                Attributes.SIZE -> Size
                Attributes.SPECIES_FACTOR -> SpeciesFactor
            }
        }

        return total
    }
}
