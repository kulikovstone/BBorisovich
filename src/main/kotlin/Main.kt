import dev.inmo.tgbotapi.bot.ktor.telegramBot
import dev.inmo.tgbotapi.extensions.api.bot.getMe
import dev.inmo.tgbotapi.extensions.api.send.reply
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviourWithLongPolling
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import secret.TOKEN

suspend fun main() {

    val bot = telegramBot(TOKEN)

    val scope = CoroutineScope(Dispatchers.Default)

    bot.buildBehaviourWithLongPolling(scope) {
        val me = getMe()

        // this method will create point to react on each /start command
        onCommand("start", requireOnlyCommandInMessage = true) {
            // simply reply :)
            reply(it, "${me.firstName} fuck your ass!")
        }

        onText {
            reply(it, "${me.firstName} / $it / fuck youuuuuuuur ass!")
        }

        // That will be called on the end of bot initiation. After that println will be started long polling and bot will
        // react on your commands
        println(me)
    }.join()

}