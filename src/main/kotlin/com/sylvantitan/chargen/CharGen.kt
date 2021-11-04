package com.sylvantitan.chargen

import com.sylvantitan.chargen.controllers.MainMenuController
import tornadofx.*

class CharGen: App() {

    init {
        find(MainMenuController::class)
    }
}

fun main(args: Array<String>) {
    launch<CharGen>(args)
}