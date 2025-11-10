package pl.dewersee.herobrine

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.SimpleCommandMap
import org.bukkit.plugin.java.JavaPlugin
import pl.dewersee.herobrine.commands.HelloCommand
import org.bukkit.command.Command as BukkitCommand

class HerobrinePlugin : JavaPlugin() {

    override fun onEnable() {
        logger.info("Herobrine plugin został włączony!")

        // Rejestracja komendy programowo
        server.commandMap.register("herobrine", object : BukkitCommand("hello") {
            override fun execute(sender: CommandSender, label: String, args: Array<out String>): Boolean {
                return HelloCommand().onCommand(sender, this, label, args)
            }
        })
    }

    override fun onDisable() {
        logger.info("Herobrine plugin został wyłączony!")
    }
}