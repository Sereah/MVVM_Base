package com.lunacattus.my_base.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lunacattus.my_base.R
import com.lunacattus.my_base.databinding.ActivityHomeBinding
import com.lunacattus.my_base.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel : HomeViewModel by viewModels()
    private var adapter: HomeAdapter = HomeAdapter()
    private var binding: ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding?.let {
            binding?.lifecycleOwner = this
            binding?.viewmodel = viewModel
            binding?.messageList?.adapter = adapter
        }
        observes()
    }

    private fun observes() {
        viewModel.messages.observe(this) {
            adapter.submitList(it.toList())
            if (adapter.itemCount > 0) {
                binding?.messageList?.smoothScrollToPosition(adapter.itemCount - 1)
            }
        }

        viewModel.hideKeyBoardEvent.observe(this) {
            hideKeyBoard()
        }
    }

    private fun hideKeyBoard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = currentFocus ?: View(this)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}