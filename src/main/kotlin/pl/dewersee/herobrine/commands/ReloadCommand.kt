package pl.dewersee.herobrine.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class ReloadCommand(val plugin: JavaPlugin) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        plugin.reloadConfig()
        sender.sendMessage("§aUstawienia zostały przeładowane!")
        return true
    }
}