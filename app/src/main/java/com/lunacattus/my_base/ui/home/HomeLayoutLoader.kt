package com.lunacattus.my_base.ui.home

import com.lunacattus.my_base.R
import com.lunacattus.my_base.ui.base.LayoutLoader
import javax.inject.Inject

class HomeLayoutLoader @Inject constructor() : LayoutLoader<HomeActivity> {

    override fun setContentView(activity: HomeActivity) {
        val layout: Int = R.layout.activity_home
        activity.setContentView(layout)
    }
}