package fr.kstars.pluginslab.commands;

import fr.kstars.pluginslab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Feed implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length > 1) {
            player.sendMessage("§cUsage: /feed <player> [OPTIONAL]");
            return false;
        }

        if (args.length == 1) {
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if (targetPlayer == null) {
                player.sendMessage("§cError: Player " + args[0] + " is not online!");
                return false;
            }

            targetPlayer.setFoodLevel(20);
            targetPlayer.sendMessage(ChatUtils.PluginPrefix + "§fYou've had your fill!");
            targetPlayer.playSound(targetPlayer.getLocation(), Sound.ENTITY_GENERIC_EAT, 1f, 1f);

            player.sendMessage(ChatUtils.PluginPrefix + "§fYou have satiated §6" + targetPlayer.getName() + "§f!");
            return true;
        }

        player.setFoodLevel(20);
        player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EAT, 1f, 1f);
        player.sendMessage(ChatUtils.PluginPrefix + "§fYou've had your fill!");
        return true;
    }
}
