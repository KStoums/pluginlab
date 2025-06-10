package fr.kstars.pluginslab.commands;

import fr.kstars.pluginslab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (!player.isOp()) {
            player.sendMessage(ChatUtils.ErrCmdNoPermission);
            return false;
        }

        if (args.length > 1) {
            player.sendMessage("§4Usage: /fly <player> [OPTIONAL]");
            return false;
        }

        if (args.length == 1) {
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if (targetPlayer == null) {
                player.sendMessage(ChatUtils.ErrPlayerIsNotOnline.replace("%player%", args[0]));
                return false;
            }

            targetPlayer.setAllowFlight(!targetPlayer.getAllowFlight());
            if (targetPlayer.getAllowFlight()) {
                targetPlayer.sendMessage(ChatUtils.PluginPrefix + "§fYou can now fly!");
                player.sendMessage(ChatUtils.PluginPrefix + "§fYou have §aactivated §fthe possibility to fly to §4" + targetPlayer.getName() + "§f.");
            } else {
                targetPlayer.sendMessage(ChatUtils.PluginPrefix + "§fYou can no longer fly!");
                player.sendMessage(ChatUtils.PluginPrefix + "§fYou have §4disabled §fthe possibility to fly to §4" + targetPlayer.getName() + "§f.");
            }

            targetPlayer.playSound(targetPlayer.getLocation(), Sound.ENTITY_PARROT_FLY, 1, 1);
            return true;
        }

        player.setAllowFlight(!player.getAllowFlight());
        if (player.getAllowFlight()) {
            player.sendMessage(ChatUtils.PluginPrefix + "§fYou can now fly.");
        } else {
            player.sendMessage(ChatUtils.PluginPrefix + "§fYou can no longer fly.");
        }
        player.playSound(player.getLocation(), Sound.ENTITY_PARROT_FLY, 1, 1);
        return true;
    }
}
