package pl.dewersee.herobrine

import org.bukkit.plugin.java.JavaPlugin
import pl.dewersee.herobrine.commands.HelloCommand

class HerobrinePlugin : JavaPlugin() {

    override fun onEnable() {
        logger.info("Herobrine plugin został włączony!");
        getCommand("hello")?.setExecutor(HelloCommand())
    }

    override fun onDisable() {
        logger.info("Herobrine plugin został wyłączony!");
    }
}