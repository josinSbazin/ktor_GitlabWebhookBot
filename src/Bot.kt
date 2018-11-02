package com.example

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

class Bot(private val app: BotApplication) : TelegramLongPollingBot() {
    override fun getBotUsername(): String {
        return BOT_USERNAME
    }

    override fun getBotToken(): String {
        return System.getenv(BOT_SECRET_ENV_NAME)
    }

    override fun onUpdateReceived(update: Update?) {
        if (update?.hasMessage() == true && update.message.isCommand) {
            if (update.message.text == BOT_REGISTER) {
                app.register(update.message.chatId, this)
            }
        }
    }

    companion object {
        private const val BOT_USERNAME = "WbGitlabBot"
        private const val BOT_SECRET_ENV_NAME = "BOT_SECRET"
        private const val BOT_REGISTER = "/register"
    }

}