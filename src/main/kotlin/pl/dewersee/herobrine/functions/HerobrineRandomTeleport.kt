package pl.dewersee.herobrine.functions

import org.bukkit.Location
import org.bukkit.entity.Zombie
import org.bukkit.plugin.java.JavaPlugin
import kotlin.math.cos
import kotlin.math.sin

class HerobrineRandomTeleport {
    fun tp(plugin: JavaPlugin) {
        val world = plugin.server.worlds.firstOrNull() ?: return
        val players = world.players
        if (players.isEmpty()) return

        val herobrine = world.entities.filterIsInstance<Zombie>().firstOrNull { it.scoreboardTags.contains("herobrine") } ?: return

        val player = players.random()

        val distance = (5..15).random()
        val angle = Math.random() * 2 * Math.PI
        val dx = (cos(angle) * distance).toInt()
        val dz = (sin(angle) * distance).toInt()

        val x = player.location.blockX + dx
        val z = player.location.blockZ + dz
        val y = world.getHighestBlockYAt(x, z) + 1

        herobrine.teleport(Location(world, x.toDouble(), y.toDouble(), z.toDouble()))
    }
}