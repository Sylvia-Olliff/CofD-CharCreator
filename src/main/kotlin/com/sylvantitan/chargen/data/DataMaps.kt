package com.sylvantitan.chargen.data

import com.sylvantitan.chargen.data.utils.DataFuncs
import com.sylvantitan.chargen.models.stats.Merit
import swaydb.KeyVal
import swaydb.java.Map
import swaydb.java.persistent.PersistentMap
import swaydb.java.serializers.Default.intSerializer
import swaydb.java.serializers.Default.stringSerializer
import java.nio.file.Paths

object DataMaps {
    private val MeritMap: Map<Int, String, Void> = PersistentMap
        .functionsOff(Paths.get("./feats"), intSerializer(), stringSerializer())
        .get()

    private val SpellMap: Map<Int, String, Void> = PersistentMap
        .functionsOff(Paths.get("./spells"), intSerializer(), stringSerializer())
        .get()

    fun getMerit(id: Int): Merit? {
        return if (MeritMap.contains(id)) {
            val strVal = MeritMap.get(id)
            Merit.deserialize(strVal.get())
        } else null
    }

    fun addMerits(vararg merit: Merit) {
        MeritMap.put(merit.map { KeyVal(it.id, it.serialize()) })
    }

    init {
    }
}