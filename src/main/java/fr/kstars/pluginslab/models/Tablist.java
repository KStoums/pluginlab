package fr.kstars.pluginslab.models;

import fr.kstars.pluginslab.utils.ChatUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class Tablist {

    public static void setTablist(Player player) {
        Component header = Component.text("§8§m───────§4§lPLUGINSLAB§8§m───────");
        Component footer = Component.text("§fPlugins Laboraty server, don't do anything stupid!");

        player.sendPlayerListHeaderAndFooter(header, footer);

        if (player.isOp()) {
            player.playerListName(Component.text(ChatUtils.OpPlayerPrefix + "§f" + player.getName()));
        }
    }
}
