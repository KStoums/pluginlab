package fr.kstars.pluginslab.commands;

import fr.kstars.pluginslab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
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

        if (!player.isOp()) {
            player.sendMessage(ChatUtils.ErrCmdNoPermission);
            return false;
        }

        if (args.length > 1) {
            player.sendMessage("§4Usage: /heal <player> [OPTIONAL]");
            return false;
        }

        if (args.length == 1) {
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if  (targetPlayer == null) {
                player.sendMessage(ChatUtils.ErrPlayerIsNotOnline.replace("%player%", args[0]));
                return false;
            }

            targetPlayer.heal(Objects.requireNonNull(player.getAttribute(Attribute.MAX_HEALTH)).getBaseValue());
            targetPlayer.sendMessage(ChatUtils.PluginPrefix + "§fYou've been heal.");
            targetPlayer.playSound(targetPlayer.getLocation(), Sound.ENTITY_SPLASH_POTION_BREAK, 1, 1);

            player.sendMessage(ChatUtils.PluginPrefix + "§fYou heal §4" + targetPlayer.getName() + "§f.");
            return true;
        }

        player.heal(Objects.requireNonNull(player.getAttribute(Attribute.MAX_HEALTH)).getBaseValue());
        player.playSound(player.getLocation(), Sound.ENTITY_SPLASH_POTION_BREAK, 1, 1);
        player.sendMessage(ChatUtils.PluginPrefix + "§fYou've been heal.");
        return true;
    }
}
