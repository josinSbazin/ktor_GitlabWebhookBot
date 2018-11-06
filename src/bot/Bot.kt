package bot

import com.example.bot.IBot
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class Bot : TelegramLongPollingBot(), IBot {
    private val listeners: MutableList<(Long, String) -> Unit> = mutableListOf()

    init {
        ApiContextInitializer.init()
        val api = TelegramBotsApi()
        api.registerBot(this)
    }

    override fun getBotUsername(): String {
        return BOT_USERNAME
    }

    override fun getBotToken(): String {
        return System.getenv(BOT_SECRET_ENV_NAME)
    }

    override fun onUpdateReceived(update: Update?) {
        if (update?.hasMessage() == true) {
            listeners.forEach { it.invoke(update.message.chatId, update.message.text) }
        }
    }

    override fun sendMessage(chatId: Long, text: String) {
        val sendMessage = SendMessage(chatId, text)
        execute(sendMessage)
    }

    override fun addOnNewMessageListener(listener: (Long, String) -> Unit) {
        listeners.add(listener)
    }

    companion object {
        private const val BOT_USERNAME = "WbGitlabBot"
        private const val BOT_SECRET_ENV_NAME = "BOT_SECRET"
    }
}