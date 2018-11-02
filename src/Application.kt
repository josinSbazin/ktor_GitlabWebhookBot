package com.example

import io.ktor.application.*
import io.ktor.html.respondHtml
import io.ktor.request.*
import io.ktor.routing.*
import kotlinx.html.*
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

fun main(args: Array<String>): Unit = io.ktor.server.netty.DevelopmentEngine.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    BotApplication().apply { main() }
}

class BotApplication {
    private var chatId: Long? = null
    private var bot: Bot? = null

    fun Application.main() {
        routing {
            ApiContextInitializer.init()
            val api = TelegramBotsApi()
            val bot = Bot(this@BotApplication)
            api.registerBot(bot)

            get("/hey") {
                call.respondHtml {
                    body {
                        h1 { +"WAZUUP" }
                    }
                }
            }

            post("/gitlab") {
                val text = call.receiveText()
                try {
                    sendMessage(text)
                } catch (e: TelegramApiException) {
                    log.error(e.message)
                }
            }
        }
    }

    fun register(chatId: Long?, bot: Bot) {
        this.chatId = chatId
        this.bot = bot
        try {
            sendMessage("Bot registered!")
        } catch (e: TelegramApiException) {
            //NA
        }
    }

    private fun sendMessage(text: String) {
        chatId?.let { id ->
            val sendMessage = SendMessage(id, text)
            bot?.execute(sendMessage)
        }
    }
}

