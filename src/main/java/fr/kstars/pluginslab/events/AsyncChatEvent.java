package fr.kstars.pluginslab.events;

import fr.kstars.pluginslab.utils.ChatUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AsyncChatEvent implements Listener {

    @EventHandler
    public void onChat(io.papermc.paper.event.player.AsyncChatEvent event) {
        Player player = event.getPlayer();
        String playerPrefix = player.getName();
        if (player.isOp()) {
            playerPrefix = ChatUtils.OpPlayerPrefix + "§f" + player.getName();
        }

        Component newPlayerName = Component.text(playerPrefix);
        event.renderer((p, displayName, message, audience) ->
                Component.text()
                    .append(newPlayerName)
                    .append(Component.text(" §f: "))
                    .append(message)
                    .build()
        );
    }
}
