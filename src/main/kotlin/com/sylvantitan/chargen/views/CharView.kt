package com.sylvantitan.chargen.views

import com.sylvantitan.chargen.models.Character
import javafx.scene.control.TableView
import tornadofx.readonlyColumn

class CharView : TableView<Character>() {

    init {
        columnResizePolicy = CONSTRAINED_RESIZE_POLICY
        readonlyColumn("Name", Character::Name)
        
    }
}