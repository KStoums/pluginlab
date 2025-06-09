package fr.kstars.pluginslab.events;

import fr.kstars.pluginslab.models.Scoreboard;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.time.Duration;
import java.util.Collection;

import static fr.kstars.pluginslab.commands.Spawn.WordSpawnLocation;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        event.joinMessage(Component.empty());

        Player player = event.getPlayer();
        player.teleport(WordSpawnLocation);

        Title joinTitle = Title.title(
                Component.text("§4Welcome !"),
                Component.text("§fDon't do anything stupid :)"),
                Title.Times.times(Duration.ofSeconds(1), Duration.ofSeconds(3), Duration.ofSeconds(1))
        );
        player.showTitle(joinTitle);
        Scoreboard.setScoreboard(player);
        player.setGameMode(GameMode.ADVENTURE);

        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        for (Player onlinePlayer : onlinePlayers) {
            Scoreboard.setScoreboard(onlinePlayer);
        }

//        if (player.isOp()) {
//            player.setGameMode(GameMode.CREATIVE);
//        }
    }
}
