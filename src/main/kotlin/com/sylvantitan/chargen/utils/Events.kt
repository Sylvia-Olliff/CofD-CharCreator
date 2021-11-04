package com.sylvantitan.chargen.utils

import tornadofx.EventBus.RunOn.BackgroundThread
import tornadofx.FXEvent

data class NewCharacterEvent(val placeholder: String) : FXEvent(BackgroundThread)
data class CharGenCreateEvent(val placeholder: String): FXEvent(BackgroundThread)