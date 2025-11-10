package pl.dewersee.herobrine.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor

class HerobrineCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Tylko gracz może użyć tej komendy!")
            return true
        }

        if (!sender.hasPermission("herobrine.use")) {
            sender.sendMessage("§cNie masz permisji do tej komendy!")
            return true
        }

        val loc = sender.location
        val world = sender.world

        val zombie = world.spawnEntity(loc, EntityType.ZOMBIE) as org.bukkit.entity.Zombie
        zombie.customName(Component.text("Herobrine").color(NamedTextColor.RED))
        zombie.isCustomNameVisible = true

        sender.sendMessage("§cHerobrine został przywołany!")

        return true
    }
}