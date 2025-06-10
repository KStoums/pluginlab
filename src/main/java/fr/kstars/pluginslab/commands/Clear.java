package fr.kstars.pluginslab.commands;

import fr.kstars.pluginslab.events.PlayerJoinEvent;
import fr.kstars.pluginslab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Clear implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length > 1) {
            player.sendMessage("§cUsage: /clear <player> [OPTIONAL]");
            return false;
        }

        if (args.length == 1) {
            Player targetPlayer = Bukkit.getPlayer(args[0]);
            if (targetPlayer == null) {
                player.sendMessage(ChatUtils.ErrPlayerIsNotOnline.replace("%player%", args[0]));
                return false;
            }

            targetPlayer.getInventory().clear();
            PlayerJoinEvent.giveJoinItems(targetPlayer);

            targetPlayer.sendMessage(ChatUtils.PluginPrefix + "§fYour inventory has been §4deleted §f by a member of the §4administration§f.");
            targetPlayer.playSound(targetPlayer.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, 1);

            player.sendMessage(ChatUtils.PluginPrefix + "§fYou've §4deleted §fthe §4" + targetPlayer.getName() + "' §finventory.");
            return true;
        }

        player.getInventory().clear();
        PlayerJoinEvent.giveJoinItems(player);
        player.sendMessage(ChatUtils.PluginPrefix + "§fYou've §4deleted §fyour inventory.");
        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, 1, 1);
        return true;
    }
}
