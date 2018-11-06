package com.example.bot

interface IBot {
    fun sendMessage(chatId: Long, text: String)
    fun addOnNewMessageListener(listener: (Long, String) -> Unit)
}