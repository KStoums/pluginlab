package fr.kstars.pluginslab.guis.navigation;

import fr.kstars.pluginslab.commands.Spawn;
import fr.kstars.pluginslab.utils.TeleportAnimation;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NavigationInventoryClickEvent implements Listener {
    public final JavaPlugin plugin;

    public NavigationInventoryClickEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }

        if (event.isCancelled()) return;

        if (event.getCurrentItem() == null) return;

        String itemDisplayName = PlainTextComponentSerializer.plainText().serialize(event.getCurrentItem().displayName());

        switch (itemDisplayName) {
            case "[" + Navigation.CompassNavigationName + "]":
                event.setCancelled(true);
                return;

            case "[" + Navigation.LaboratoryItemName + "]":
                player.closeInventory();
                TeleportAnimation.startTeleportAnimation(this.plugin, player, Spawn.WordSpawnLocation);
                event.setCancelled(true);
                return;

            case "[" + Navigation.BetterCallSaulOfficeItemName + "]":
                player.closeInventory();
                Location betterCallSaulOfficeLocation = new Location(player.getWorld(), 149.475, -8, -9.475, 90, 0);
                TeleportAnimation.startTeleportAnimation(this.plugin, player, betterCallSaulOfficeLocation);
                event.setCancelled(true);
                return;

            case "[" + Navigation.LosPollosHermanosItemName + "]":
                player.closeInventory();
                Location losPollosHermanosLocation = new Location(player.getWorld(), -10.550, -7.5, -116.515);
                TeleportAnimation.startTeleportAnimation(this.plugin, player, losPollosHermanosLocation);
                event.setCancelled(true);
        }
    }
}
