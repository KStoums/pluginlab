package fr.kstars.pluginslab.events;

import fr.kstars.pluginslab.guis.navigation.Navigation;
import fr.kstars.pluginslab.models.Tablist;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.time.Duration;
import java.util.List;

import static fr.kstars.pluginslab.commands.Spawn.WordSpawnLocation;
import static fr.kstars.pluginslab.models.Scoreboard.updatePlayersScoreboard;

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
        player.setGameMode(GameMode.ADVENTURE);

        Tablist.setTablist(player);
        updatePlayersScoreboard();
        giveJoinItems(player);

//        if (player.isOp()) {
//            player.setGameMode(GameMode.CREATIVE);
//        }
    }

    public static void giveJoinItems(Player player) {
        player.getInventory().clear();

        ItemStack navigateCompass = new ItemStack(Material.OAK_DOOR);
        ItemMeta itemMeta = navigateCompass.getItemMeta();
        itemMeta.displayName(Component.text(Navigation.CompassNavigationName));
        itemMeta.lore(List.of(
                Component.text("§8Right/Left click to navigate")
        ));

        navigateCompass.setItemMeta(itemMeta);
        player.getInventory().setItem(4, navigateCompass);
    }
}
