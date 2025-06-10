package fr.kstars.pluginslab.commands;

import fr.kstars.pluginslab.utils.ChatUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Kick implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (!player.isOp()) {
            player.sendMessage(ChatUtils.ErrCmdNoPermission);
            return false;
        }

        if (args.length == 0) {
            player.sendMessage("§4Usage: /kick <player> <reason>");
            return false;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            player.sendMessage(ChatUtils.ErrPlayerIsNotOnline.replace("%player%", args[0]));
            return false;
        }

        String reason = "No reason provided";
        if (args.length > 1) {
            reason = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        }

        targetPlayer.kick(Component.text("§4You've been excluded from PluginsLab!\n§7Reason: §f" + reason));
        player.sendMessage(ChatUtils.PluginPrefix + "§fYou §4kicked §fthe §4" + targetPlayer.getName() + " §ffor the reason: §4" + reason);
        return true;
    }
}
