package fr.kstars.pluginlab.commands;

import fr.kstars.pluginlab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length > 1) {
            player.sendMessage("§cUsage: /heal <player> [OPTIONAL]");
            return false;
        }

        if (args.length == 1) {
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if  (targetPlayer == null) {
                player.sendMessage("§cError: Player " + args[0] + " not found!");
                return false;
            }

            targetPlayer.heal(Objects.requireNonNull(player.getAttribute(Attribute.MAX_HEALTH)).getBaseValue());
            targetPlayer.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou've been heal!");
            player.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou heal §6" + targetPlayer.getName() + "§f!");
            return true;
        }

        player.heal(Objects.requireNonNull(player.getAttribute(Attribute.MAX_HEALTH)).getBaseValue());
        player.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou've been heal!");
        return true;
    }
}
