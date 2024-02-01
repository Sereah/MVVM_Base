package com.lunacattus.my_base.model

import javax.inject.Inject

class User @Inject constructor(private val device: Device) {
    fun use(){
        device.show()
    }
}