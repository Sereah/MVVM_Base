package com.lunacattus.my_base.viewmodel

import android.view.Gravity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.lunacattus.my_base.BaseViewModel
import com.lunacattus.my_base.model.ChatMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(model: GenerativeModel) : BaseViewModel() {
    private val _messages = MutableLiveData<MutableList<ChatMessage>>(mutableListOf())
    var messages : LiveData<MutableList<ChatMessage>> = _messages

    private val _hideKeyBoardEvent = MutableLiveData<Unit>()
    var hideKeyBoardEvent : LiveData<Unit> = _hideKeyBoardEvent

    val inputText = MutableLiveData<String>()

    private val chat = model.startChat()

    fun sendMessage() {
        hideKeyBoard()
        val messageText = inputText.value ?: return
        if (messageText.isNotEmpty()) {
            val userMessage = ChatMessage(messageText, "User", gravity = Gravity.END)
            addMessage(userMessage)
            inputText.value = ""


            val loadingMessage = ChatMessage("loading...", "Model", true)
            addMessage(loadingMessage)

            viewModelScope.launch {
                try {
                    val response = chat.sendMessage(messageText)
                    response.text?.let {
                        removeLoading()
                        addMessage(ChatMessage(it, "Model"))
                    }
                } catch (e: Exception) {
                    removeLoading()
                    e.localizedMessage?.let {
                        addMessage(ChatMessage(it, "Error"))
                    }
                }
            }
        }
    }

    private fun hideKeyBoard() {
        _hideKeyBoardEvent.value = Unit
    }

    private fun addMessage(message: ChatMessage) {
        val updateList = _messages.value ?: mutableListOf()
        updateList.add(message)
        _messages.value = updateList
    }

    private fun removeLoading() {
        val updateList = _messages.value ?: mutableListOf()
        if (updateList.isNotEmpty() && updateList.last().sender == "Model" && updateList.last().isLoading) {
            updateList.removeAt(updateList.size - 1)
            _messages.value = updateList
        }
    }
}