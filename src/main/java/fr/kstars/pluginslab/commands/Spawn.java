package fr.kstars.pluginslab.commands;

import fr.kstars.pluginslab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Spawn implements CommandExecutor {

    public final static Location WordSpawnLocation = new Location(Bukkit.getWorld("world"), 26.480, 0, 7.504, 0f, 0);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        player.teleport(WordSpawnLocation);
        player.sendMessage(ChatUtils.PluginPrefix + "§fYou have been §6teleported §fto the §6spawn§f.");
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
        return true;
    }
}
