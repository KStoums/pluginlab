package fr.kstars.pluginlab.events;

import fr.kstars.pluginlab.utils.ChatUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static fr.kstars.pluginlab.commands.Spawn.WordSpawnLocation;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        event.joinMessage(Component.empty());

        Player player = event.getPlayer();
        player.teleport(WordSpawnLocation);
        player.sendMessage(ChatUtils.PluginMessagePrefix + "§fWelcome ! Don't do anything stupid :)");
    }
}
