package com.ligadosprogramadores.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent


// Como o nome da classe já diz, ela vai servir como base para todos os proximos comandos criados.
open abstract class CommandBase {

    open abstract fun getLabel() : String // Esse vai ser nosso comando.

    open abstract fun run(event: MessageReceivedEvent) // Esse vai ser nosso evento

    // Isso seria caso o comando tivesse uma aliase, que seria por exemplo, o comando é p!addlang, então o usuario pode usalo como p!al ou outro.
    open fun getAliases(): List<String> {
        return listOf()
    }

    // Descrição do comando.
    open fun getDescription() : String {
        return "Insira uma descrição here"
    }
    // Um exemplo do comando.
    open fun getExample(): List<String> {
        return listOf()
    }
    // Finalmente vamos para parte que pega o comando quando executado.
    fun handle(ev: MessageReceivedEvent) {
        var prefix: String = "b!" // Esse vai ser o prefixo do nosso bot.
        if (ev.message.contentDisplay.startsWith(prefix)) {
            run(ev) // Se caso a mensagem começar com o prefixo, então ele vai executar o comando.
        }
    }

}