package pl.dewersee.herobrine.functions

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockIgniteEvent
import org.bukkit.plugin.java.JavaPlugin

data class BlockPosition(val x: Int, val y: Int, val z: Int, val type: Material)

class Totem(val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onBlockIgnite(event: BlockIgniteEvent) {
        val player = event.player
        val block = event.block
        val world = block.world

        if (player !is Player) return
        val bl = world.getBlockAt(block.x, block.y -1, block.z)
        plugin.logger.info(bl.type.toString())
        if (bl.type != Material.NETHERRACK) return

        val totemBlocks = arrayOf(
            BlockPosition(-1, -2, 1, Material.GOLD_BLOCK),
            BlockPosition(-1, -2, 0, Material.GOLD_BLOCK),
            BlockPosition(-1, -2, -1, Material.GOLD_BLOCK),

            BlockPosition(0, -2, 1, Material.GOLD_BLOCK),
            BlockPosition(0, -2, 0, Material.MOSSY_COBBLESTONE),
            BlockPosition(0, -2, -1, Material.GOLD_BLOCK),

            BlockPosition(1, -2, 1, Material.GOLD_BLOCK),
            BlockPosition(1, -2, 0, Material.GOLD_BLOCK),
            BlockPosition(1, -2, -1, Material.GOLD_BLOCK),


            BlockPosition(-1, -1, 1, Material.AIR),
            BlockPosition(-1, -1, 0, Material.REDSTONE_TORCH),
            BlockPosition(-1, -1, -1, Material.AIR),

            BlockPosition(0, -1, 1, Material.REDSTONE_TORCH),
            BlockPosition(0, -1, 0, Material.NETHERRACK),
            BlockPosition(0, -1, -1, Material.REDSTONE_TORCH),

            BlockPosition(1, -1, 1, Material.AIR),
            BlockPosition(1, -1, 0, Material.REDSTONE_TORCH),
            BlockPosition(1, -1, -1, Material.AIR),
        )

        var isTotem = 0

        for (bp in totemBlocks) {
            val b = world.getBlockAt(block.x + bp.x, block.y + bp.y, block.z + bp.z)
            plugin.logger.info(" x: " + b.x.toString() + " y: " + b.y.toString()+ " z: " + b.z.toString() + " " + b.type.toString())
            if (b.type != bp.type) {
               break
            }
            isTotem++
        }

        if (isTotem == 18) {
            player.sendMessage("OK")
            val zombie = world.spawnEntity(player.location, EntityType.ZOMBIE) as org.bukkit.entity.Zombie
            zombie.customName(Component.text("Herobrine").color(NamedTextColor.RED))
            zombie.isCustomNameVisible = true
        }
    }
}