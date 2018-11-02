package com.example

import com.example.data.mergeRequest.MergeRequestModel
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.application.log
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.html.respondHtml
import io.ktor.request.receive
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import kotlinx.html.body
import kotlinx.html.h1
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import java.text.DateFormat

fun main(args: Array<String>): Unit = io.ktor.server.netty.DevelopmentEngine.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    BotApplication().apply { main() }
}

class BotApplication {
    private var bot: Bot? = null
    private val registredChatsIds: MutableSet<Long> = mutableSetOf()

    fun Application.main() {
        install(ContentNegotiation) {
            gson {
                setDateFormat(DateFormat.LONG)
                setPrettyPrinting()
            }
        }

        routing {
            ApiContextInitializer.init()
            val api = TelegramBotsApi()
            bot = Bot(this@BotApplication)
            api.registerBot(bot)

            get("/hey") {
                call.respondHtml {
                    body {
                        h1 { +"WAZUUP" }
                    }
                }
            }

            post("/gitlab") {
                val model = call.receive<MergeRequestModel>()
                try {
                    for (chatId in registredChatsIds) {
                        sendMessage(chatId, model.toString())
                    }
                } catch (e: TelegramApiException) {
                    log.error(e.message)
                }
            }
        }
    }

    fun register(chatId: Long?) {
        if (chatId != null) {
            registredChatsIds.add(chatId)
            try {
                sendMessage(chatId, "Bot registered!")
            } catch (e: TelegramApiException) {
                //NA
            }
        }
    }

    fun unregister(chatId: Long?) {
        if (chatId != null) {
            registredChatsIds.remove(chatId)
        }
    }

    private fun sendMessage(chatId: Long, text: String) {
        chatId.let { id ->
            val sendMessage = SendMessage(id, text)
            bot?.execute(sendMessage)
        }
    }
}

