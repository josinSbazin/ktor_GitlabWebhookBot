package com.example

import bot.Bot
import com.example.bot.IBot
import com.example.data.mergeRequest.MergeRequestModel
import com.example.io.IDb
import com.example.io.simple.FileWriterReader
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

fun main(args: Array<String>): Unit = io.ktor.server.netty.DevelopmentEngine.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    BotApplication().apply { main() }
}

class BotApplication {
    private lateinit var bot: IBot
    private lateinit var db: IDb

    fun Application.main() {
        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
            }
        }

        initBot()
        initDb()

        routing {
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
                    db.getChatIds().forEach { id ->
                        bot.sendMessage(id, model.toString())
                    }
                } catch (e: Exception) {
                    log.error(e.message)
                    log.error(e.stackTrace.toString())
                }
            }
        }
    }

    private fun register(chatId: Long?) {
        if (chatId != null) {
            try {
                if (db.addChatId(chatId)) {
                    bot.sendMessage(chatId, "Chat registered")
                } else {
                    bot.sendMessage(chatId, "Warning! Chat already registered")
                }
            } catch (e: Exception) {
                bot.sendMessage(chatId, "ERROR! " + e.message)
            }
        }
    }


    private fun unregister(chatId: Long?) {
        if (chatId != null) {
            try {
                if (db.removeChatId(chatId)) {
                    bot.sendMessage(chatId, "Chat unregistered")
                } else {
                    bot.sendMessage(chatId, "Have not chat id in registered list")
                }
            } catch (e: Exception) {
                bot.sendMessage(chatId, "ERROR! " + e.message)
            }
        }
    }

    private fun onBotMessageReceived(chatId: Long, message: String) {
        when (message) {
            BOT_REGISTER -> register(chatId)
            BOT_UNREGISTER -> unregister(chatId)
            else -> bot.sendMessage(chatId, "Unresolved command")
        }

    }

    //todo use DI
    private fun initBot() {
        bot = Bot()
        bot.addOnNewMessageListener(::onBotMessageReceived)
    }

    //todo use DI
    private fun initDb() {
        db = FileWriterReader()
    }

    private companion object {
        private const val BOT_REGISTER = "/register"
        private const val BOT_UNREGISTER = "/unregister"
    }
}

