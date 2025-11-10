package pl.dewersee.herobrine

import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import pl.dewersee.herobrine.commands.ReloadCommand
import pl.dewersee.herobrine.commands.HerobrineCommand
import pl.dewersee.herobrine.functions.HerobrineDeathListener
import org.bukkit.command.Command as BukkitCommand
import pl.dewersee.herobrine.functions.HerobrineTotem
import pl.dewersee.herobrine.functions.HerobrineAttackListener

class HerobrinePlugin : JavaPlugin() {
    override fun onEnable() {
        saveDefaultConfig()
        logger.info("Herobrine plugin został włączony!")

        server.commandMap.register("herobrine", object : BukkitCommand("hreload") {
            override fun execute(sender: CommandSender, label: String, args: Array<out String>): Boolean {
                return ReloadCommand(this@HerobrinePlugin).onCommand(sender, this, label, args)
            }
        })
        server.commandMap.register("herobrine", object : BukkitCommand("herobrine") {
            override fun execute(sender: CommandSender, label: String, args: Array<out String>): Boolean {
                return HerobrineCommand(this@HerobrinePlugin).onCommand(sender, this, label, args)
            }
        })

        server.pluginManager.registerEvents(HerobrineTotem(this), this)
        server.pluginManager.registerEvents(HerobrineAttackListener(this), this)
        server.pluginManager.registerEvents(HerobrineDeathListener(this), this)
    }

    override fun onDisable() {
        logger.info("Herobrine plugin został wyłączony!")
    }
}