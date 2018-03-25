package com.ligadosprogramadores.commands

import net.dv8tion.jda.core.EmbedBuilder
import net.dv8tion.jda.core.events.message.MessageReceivedEvent

class PollCommand : CommandBase(){
    override fun getLabel(): String {
        return "poll"
    }

    override fun run(event: MessageReceivedEvent) {
        var args: List<String> = event.message.contentRaw.split(" ")
        if (args.size >= 1) {
            val matcher = Regex("<#([0-9]+)>").find(args[1])
            if (matcher != null) {
                val guild = event.message.guild
                val channel = guild.getTextChannelById(matcher.groupValues[1])

                if (channel != null) {
                    val member = guild.getMemberById(event.author.id)
                    var builder = EmbedBuilder()
                    builder.setColor(member.colorRaw)
                    builder.setAuthor(member.effectiveName, null, event.message.author.effectiveAvatarUrl)
                    builder.addField("Votação", args[2], false)
                    channel.sendMessage(builder.build()).queue({it.addReaction("\uD83D\uDC4D").queue({addReactions: Void? -> it.addReaction("\uD83D\uDC4E").queue()})})
                    event.message.delete().queue()


                } else {
                    event.textChannel.sendMessage("Não consegui achar o canal.").queue()
                }
            }
        }
    }

}