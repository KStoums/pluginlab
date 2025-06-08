package fr.kstars.pluginlab.commands;

import fr.kstars.pluginlab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Teleport implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length == 0 || args.length > 2) {
            player.sendMessage("§cUsage: /teleport <player> <player> [OPTIONAL]");
            return false;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);

        if (targetPlayer == null) {
            player.sendMessage("§cError: Player " + args[0] + " not found!");
            return false;
        }

        if (args.length == 2) {
            Player destinationPlayer = Bukkit.getPlayer(args[1]);
            if (destinationPlayer == null) {
                player.sendMessage("§cError: Player " + args[1] + " not found!");
                return false;
            }

            targetPlayer.teleport(destinationPlayer);
            targetPlayer.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou have been teleported to §6" + destinationPlayer.getName() + "§f!");
            return true;
        }

        player.teleport(targetPlayer);
        player.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou have been teleported to §6" + targetPlayer.getName() + "§f");
        return false;
    }
}
