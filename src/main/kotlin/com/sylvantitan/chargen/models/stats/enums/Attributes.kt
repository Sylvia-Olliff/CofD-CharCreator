package com.sylvantitan.chargen.models.stats.enums

enum class Attributes(val mainCategory: AttributeMainCategory?, val sideCategory: AttributeSideCategory?) {
    INTELLIGENCE(AttributeMainCategory.MENTAL, AttributeSideCategory.POWER),
    WITS(AttributeMainCategory.MENTAL, AttributeSideCategory.FINESSE),
    RESOLVE(AttributeMainCategory.MENTAL, AttributeSideCategory.RESISTANCE),
    STRENGTH(AttributeMainCategory.PHYSICAL, AttributeSideCategory.POWER),
    DEXTERITY(AttributeMainCategory.PHYSICAL, AttributeSideCategory.FINESSE),
    STAMINA(AttributeMainCategory.PHYSICAL, AttributeSideCategory.RESISTANCE),
    PRESENCE(AttributeMainCategory.SOCIAL, AttributeSideCategory.POWER),
    MANIPULATION(AttributeMainCategory.SOCIAL, AttributeSideCategory.FINESSE),
    COMPOSURE(AttributeMainCategory.SOCIAL, AttributeSideCategory.RESISTANCE),
    SIZE(null, null),
    SPECIES_FACTOR(null, null);

    companion object {
        fun getAttributeSet(category: AttributeSideCategory): Array<Attributes> {
            return values().filter { it.sideCategory == category }.toTypedArray()
        }

        fun getAttributeSet(category: AttributeMainCategory): Array<Attributes> {
            return values().filter { it.mainCategory == category }.toTypedArray()
        }
    }
}