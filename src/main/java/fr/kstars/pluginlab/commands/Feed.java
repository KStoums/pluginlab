package fr.kstars.pluginlab.commands;

import fr.kstars.pluginlab.utils.ChatUtils;
import org.bukkit.Bukkit;
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
            targetPlayer.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou've had your fill!");
            player.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou have satiated §6" + targetPlayer.getName() + "§f!");
            return true;
        }

        player.setFoodLevel(20);
        player.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou've had your fill!");
        return true;
    }
}
