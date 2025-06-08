package fr.kstars.pluginlab.events;

import fr.kstars.pluginlab.commands.Spawn;
import fr.kstars.pluginlab.utils.ChatUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;

public class EntityDamageEvent implements Listener {
    @EventHandler
    public void onEntityDeath(org.bukkit.event.entity.EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        if (event.isCancelled()) {
            return;
        }

        if (event.getFinalDamage() < player.getHealth()) {
            return;
        }

        event.setCancelled(true);
        player.setHealth(Objects.requireNonNull(player.getAttribute(Attribute.MAX_HEALTH)).getBaseValue());
        player.teleport(Spawn.WordSpawnLocation);
        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_DEATH, 1, 1);

        Bukkit.broadcast(Component.text(ChatUtils.PluginMessagePrefix + "§fThe player §6" + player.getName() + " §fis dead!"));
    }
}
