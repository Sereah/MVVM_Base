package com.lunacattus.my_base.model

import android.view.Gravity

data class ChatMessage(val message: String, val sender: String, val isLoading: Boolean = false, val gravity: Int = Gravity.START)