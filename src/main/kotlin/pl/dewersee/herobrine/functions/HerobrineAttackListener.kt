package pl.dewersee.herobrine.functions

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.entity.Zombie
import org.bukkit.Sound
import org.bukkit.Particle

class HerobrineAttackListener(val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onZombieAttack(event: EntityDamageByEntityEvent) {
        val damager = event.damager
        if (damager is Zombie) {
            val type = damager.scoreboardTags.contains("herobrine")

            if (type) {
                val loc = damager.location
                val world = loc.world

                world.playSound(loc, Sound.ENTITY_WITHER_HURT, 1.0f, 0.8f)

                world.spawnParticle(Particle.CRIT, loc.add(0.0, 1.0, 0.0), 10, 0.3, 0.3, 0.3, 0.01)
            }
        }
    }
}