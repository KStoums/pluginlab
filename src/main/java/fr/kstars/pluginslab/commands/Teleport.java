package fr.kstars.pluginslab.commands;

import fr.kstars.pluginslab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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
            if (!player.isOp()) {
                player.sendMessage(ChatUtils.ErrorNoPermission);
                return false;
            }

            Player destinationPlayer = Bukkit.getPlayer(args[1]);
            if (destinationPlayer == null) {
                player.sendMessage("§cError: Player " + args[1] + " not found!");
                return false;
            }

            targetPlayer.teleport(destinationPlayer);
            targetPlayer.sendMessage(ChatUtils.PluginPrefix + "§fYou have been teleported to §6" + destinationPlayer.getName() + "§f!");
            targetPlayer.playSound(targetPlayer.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
            return true;
        }

        player.teleport(targetPlayer);
        player.sendMessage(ChatUtils.PluginPrefix + "§fYou have been teleported to §6" + targetPlayer.getName() + "§f");
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
        return false;
    }
}
