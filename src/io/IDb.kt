package com.example.io

interface IDb {
    fun addChatId(chatId: Long): Boolean
    fun removeChatId(chatId: Long): Boolean
    fun getChatIds(): Set<Long>
}