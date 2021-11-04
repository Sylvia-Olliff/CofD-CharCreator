package com.sylvantitan.chargen.models.stats.enums

enum class Skills(val category: AttributeMainCategory) {
    ACADEMICS(AttributeMainCategory.MENTAL),
    COMPUTER(AttributeMainCategory.MENTAL),
    CRAFTS(AttributeMainCategory.MENTAL),
    INVESTIGATION(AttributeMainCategory.MENTAL),
    MEDICINE(AttributeMainCategory.MENTAL),
    OCCULT(AttributeMainCategory.MENTAL),
    POLITICS(AttributeMainCategory.MENTAL),
    SCIENCE(AttributeMainCategory.MENTAL),
    ATHLETICS(AttributeMainCategory.PHYSICAL),
    BRAWL(AttributeMainCategory.PHYSICAL),
    DRIVE(AttributeMainCategory.PHYSICAL),
    FIREARMS(AttributeMainCategory.PHYSICAL),
    LARCENY(AttributeMainCategory.PHYSICAL),
    STEALTH(AttributeMainCategory.PHYSICAL),
    SURVIVAL(AttributeMainCategory.PHYSICAL),
    ANIMAL_KEN(AttributeMainCategory.SOCIAL),
    EMPATHY(AttributeMainCategory.SOCIAL),
    EXPRESSION(AttributeMainCategory.SOCIAL),
    INTIMIDATION(AttributeMainCategory.SOCIAL),
    PERSUASION(AttributeMainCategory.SOCIAL),
    SOCIALIZE(AttributeMainCategory.SOCIAL),
    STREETWISE(AttributeMainCategory.SOCIAL),
    SUBTERFUGE(AttributeMainCategory.SOCIAL)
}