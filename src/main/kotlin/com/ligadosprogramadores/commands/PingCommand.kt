package com.ligadosprogramadores.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

class PingCommand : CommandBase() {

    override fun getLabel(): String {
        return "ping"
    }

    override fun getDescription(): String {
        return "Retorna o ping do bot"
    }
    override fun run(event: MessageReceivedEvent) {
        event.textChannel.sendMessage("Pong! " + event.jda.ping).queue() // Você em todo final que mandar mensagem você é obrigado a colocar queue, a menos que você tenha certeza do que esta fazendo
    }

}