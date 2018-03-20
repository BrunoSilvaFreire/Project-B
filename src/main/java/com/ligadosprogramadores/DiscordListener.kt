package com.ligadosprogramadores

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter

// Nessa classe vamos colocar todos os eventos do bot.
class DiscordListener(val bot: ProjectLauncher) : ListenerAdapter() {

    // Esse vai ser o evento caso uma mensagem for recebia
     fun onMessageRecived(event: MessageReceivedEvent) {

        // Se o comando executado esta na lista de comandos então...
        for (command in bot.commands) {
            command.handle(event)
        }

    }
}