package fr.kstars.pluginslab.events;

import fr.kstars.pluginslab.models.Scoreboard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener {
    @EventHandler
    public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event){
        Scoreboard.updatePlayersScoreboard();
    }
}
