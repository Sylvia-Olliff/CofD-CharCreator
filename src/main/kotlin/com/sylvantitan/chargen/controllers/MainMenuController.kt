package com.sylvantitan.chargen.controllers

import com.sylvantitan.chargen.utils.CharGenCreateEvent
import com.sylvantitan.chargen.utils.NewCharacterEvent
import tornadofx.Controller

class MainMenuController: Controller() {
    init {
        subscribe<NewCharacterEvent> {
            fire(CharGenCreateEvent(""))
        }
    }
}