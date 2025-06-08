package fr.kstars.pluginlab.commands;

import fr.kstars.pluginlab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Kill implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length > 1) {
            player.sendMessage("§cUsage: /kill <player> [OPTIONAL]");
            return false;
        }

        if (args.length == 1) {
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if (targetPlayer == null) {
                player.sendMessage("§cError: Player " + args[0] + " not found!");
                return false;
            }

            targetPlayer.damage(targetPlayer.getHealth());
            targetPlayer.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou were §6killed §fby a member of the administration!");

            player.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou killed §6" + targetPlayer.getName() + "§f!");
            return true;
        }

        player.damage(player.getHealth());
        player.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou committed §6suicide§f!");
        return true;
    }
}
