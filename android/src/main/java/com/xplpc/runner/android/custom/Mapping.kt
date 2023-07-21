package com.xplpc.runner.android.custom

import com.xplpc.data.MappingList
import com.xplpc.map.MappingItem
import com.xplpc.runner.custom.Callback

object Mapping {
    fun initialize() {
        MappingList.add("platform.battery.level", MappingItem(Callback::batteryLevel))
    }
}
