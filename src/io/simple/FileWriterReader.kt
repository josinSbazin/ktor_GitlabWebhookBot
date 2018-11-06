package com.example.io.simple

import com.example.io.IDb
import java.io.BufferedReader
import java.io.FileReader
import java.io.FileWriter

class FileWriterReader : IDb {
    override fun getChatIds(): Set<Long> {
        BufferedReader(FileReader(CHATS_FILE_NAME)).use { bufferedReader ->
            return bufferedReader.lineSequence().map { it.toLong() }.toSet()
        }
    }

    override fun removeChatId(chatId: Long): Boolean {
        val chatIds = getChatIds().toMutableSet()
        if (!chatIds.remove(chatId)) return false
        writeToFile(chatIds)
        return true
    }

    override fun addChatId(chatId: Long): Boolean {
        val chatIds = getChatIds().toMutableSet()
        if (!chatIds.add(chatId)) return false
        writeToFile(chatIds)
        return true
    }

    private fun writeToFile(chatIds: Set<Long>) {
        FileWriter(CHATS_FILE_NAME).use {
            it.write(chatIds.joinToString("\n"))
        }
    }

    private companion object {
        private const val CHATS_FILE_NAME = "gitlab_bot_chats.registered"
    }
}