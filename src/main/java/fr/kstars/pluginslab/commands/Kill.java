package fr.kstars.pluginslab.commands;

import fr.kstars.pluginslab.utils.ChatUtils;
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

        if (!player.isOp()) {
            player.sendMessage(ChatUtils.ErrCmdNoPermission);
            return false;
        }

        if (args.length > 1) {
            player.sendMessage("§cUsage: /kill <player> [OPTIONAL]");
            return false;
        }

        if (args.length == 1) {
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if (targetPlayer == null) {
                player.sendMessage(ChatUtils.ErrPlayerIsNotOnline.replace("%player%", args[0]));
                return false;
            }

            targetPlayer.damage(targetPlayer.getHealth());
            targetPlayer.sendMessage(ChatUtils.PluginPrefix + "§fYou were §4killed §fby a member of the administration.");

            player.sendMessage(ChatUtils.PluginPrefix + "§fYou killed §4" + targetPlayer.getName() + "§f.");
            return true;
        }

        player.damage(player.getHealth());
        player.sendMessage(ChatUtils.PluginPrefix + "§fYou committed §4suicide§f.");
        return true;
    }
}
