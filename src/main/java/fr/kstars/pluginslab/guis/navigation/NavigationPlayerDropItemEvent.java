package fr.kstars.pluginslab.guis.navigation;

import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class NavigationPlayerDropItemEvent implements Listener {
    @EventHandler
    public void onDropItem(org.bukkit.event.player.PlayerDropItemEvent event) {
        if (event.isCancelled()) {
            return;
        }

        ItemStack droppedItemStack = event.getItemDrop().getItemStack();
        String itemDisplayName = PlainTextComponentSerializer.plainText().serialize(droppedItemStack.displayName());

        if (itemDisplayName.equals("[" + Navigation.CompassNavigationName + "]")) {
            event.setCancelled(true);
        }
    }
}
