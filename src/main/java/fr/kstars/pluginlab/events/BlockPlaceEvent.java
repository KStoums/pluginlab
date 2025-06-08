package fr.kstars.pluginlab.events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockPlaceEvent implements Listener {
    @EventHandler
    public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent event){
        if (event.isCancelled()) {
            return;
        }

        Player player  = event.getPlayer();

        if (player.isOp()) {
            return;
        }

        event.setCancelled(true);
        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
    }
}
