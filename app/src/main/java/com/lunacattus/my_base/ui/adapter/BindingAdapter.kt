package com.lunacattus.my_base.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("homeTextAndColor")
    fun setHomeTextAndColor(view: TextView, isShow: Boolean) {
        if (!isShow) {
            return
        }
        view.text = "Hello, Fragment."
        view.setTextColor(Color.BLACK)
    }
}