package fr.kstars.pluginslab.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerSwapHandItemsEvent implements Listener {
    @EventHandler
    public void onInventoryClick(org.bukkit.event.player.PlayerSwapHandItemsEvent event) {
        if (event.isCancelled()) {
            return;
        }

        event.setCancelled(true);
    }
}
