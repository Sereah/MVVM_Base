package com.lunacattus.my_base.ui.home

import android.os.Bundle
import com.lunacattus.my_base.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    @Inject
    lateinit var loader: HomeLayoutLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loader.setContentView(this)
    }
}