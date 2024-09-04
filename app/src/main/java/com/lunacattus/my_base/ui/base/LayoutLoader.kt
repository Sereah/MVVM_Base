package com.lunacattus.my_base.ui.base

import androidx.fragment.app.FragmentActivity

interface LayoutLoader<T: FragmentActivity> {

    fun setContentView(activity: T)
}