package pl.dewersee.herobrine

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.SimpleCommandMap
import org.bukkit.plugin.java.JavaPlugin
import pl.dewersee.herobrine.commands.HelloCommand
import pl.dewersee.herobrine.commands.HerobrineCommand
import org.bukkit.command.Command as BukkitCommand
import pl.dewersee.herobrine.functions.Totem

class HerobrinePlugin : JavaPlugin() {

    override fun onEnable() {
        logger.info("Herobrine plugin został włączony!")

        server.commandMap.register("herobrine", object : BukkitCommand("hello") {
            override fun execute(sender: CommandSender, label: String, args: Array<out String>): Boolean {
                return HelloCommand().onCommand(sender, this, label, args)
            }
        })
        server.commandMap.register("herobrine", object : BukkitCommand("herobrine") {
            override fun execute(sender: CommandSender, label: String, args: Array<out String>): Boolean {
                return HerobrineCommand().onCommand(sender, this, label, args)
            }
        })

        server.pluginManager.registerEvents(Totem(this), this)
    }

    override fun onDisable() {
        logger.info("Herobrine plugin został wyłączony!")
    }
}