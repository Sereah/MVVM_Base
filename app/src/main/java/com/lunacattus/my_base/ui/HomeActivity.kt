package com.lunacattus.my_base.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lunacattus.my_base.R
import com.lunacattus.my_base.model.User
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        user.use()
    }
}