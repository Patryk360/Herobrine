package pl.dewersee.herobrine.functions

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.entity.Zombie
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.Sound
import org.bukkit.Particle

class HerobrineDeathListener(val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onHerobrineDeath(event: EntityDeathEvent) {
        val entity = event.entity

        if (entity is Zombie) {
            val type = entity.scoreboardTags.contains("herobrine")

            if (type) {
                val loc = entity.location
                val world = loc.world

                world.playSound(loc, Sound.ENTITY_WITHER_DEATH, 1.0f, 0.8f)

                world.spawnParticle(Particle.SMOKE, loc.add(0.0, 1.0, 0.0), 30, 0.3, 0.4, 0.3, 0.02)
                world.spawnParticle(Particle.EXPLOSION, loc, 3, 0.2, 0.2, 0.2, 0.01)

                plugin.config.set("herobrine.death", true)
                plugin.saveConfig()
            }
        }
    }
}