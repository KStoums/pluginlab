package fr.kstars.pluginslab.guis.navigation;

import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class NavigationPlayerInteractEvent implements Listener {
    @EventHandler
    public void onPlayerInteract(org.bukkit.event.player.PlayerInteractEvent event) {
        if (event.getItem() == null) return;

        ItemStack interactItem = event.getItem();
        String itemDisplayName = PlainTextComponentSerializer.plainText().serialize(interactItem.displayName());

        if (itemDisplayName.equals("[" + Navigation.CompassNavigationName + "]")) {
            Navigation.openNavigationMenu(event.getPlayer());
        }
    }
}
