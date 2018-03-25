package com.ligadosprogramadores

import com.ligadosprogramadores.commands.CommandBase
import com.ligadosprogramadores.commands.PingCommand
import com.ligadosprogramadores.commands.PollCommand
import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder


// Isso o "constructor" da nossa classe
class ProjectLauncher {

    // Vamos criar uma variavel que vai ser os comandos disponiveis.
    var commands = mutableListOf<CommandBase>()

    constructor() {

        commands.add(PingCommand())
        commands.add(PollCommand())

        // Vamos falar para o JDA que a conta que estamos usando é de um bot.
        JDABuilder(AccountType.BOT)
                .setToken("") // Aqui você vai colocar o token do seu bot.
                .addEventListener(DiscordListener(this)) // Ele vai considerar todos os eventos dessa classe.
                .buildBlocking() // Vamos terminar as "configurações" do bot.
    }
}


