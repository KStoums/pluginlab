package fr.kstars.pluginslab.commands;

import fr.kstars.pluginslab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class WorldChange implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length == 0) {
            player.sendMessage("§cUsage: /worldchange <worldName>");
            return false;
        }

        String worldName = String.join(" ", args);
        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            player.sendMessage(ChatUtils.PluginPrefix + "§fWorld not found, trying to load them...");

            world = loadWorld(worldName);
            if (world == null) {
                player.sendMessage("§cError: That world doesn't exist.");
                return false;
            }
        }

        player.teleport(world.getSpawnLocation());
        player.sendMessage(ChatUtils.PluginPrefix + "§fYou've been §4teleported §fto the world §4" + world.getName() + "§f.");
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        return true;
    }

    private static World loadWorld(String worldName) {
        File worldFolder = new File(Bukkit.getServer().getWorldContainer(), worldName);
        if (!worldFolder.exists() || !worldFolder.isDirectory()) {
            return null;
        }

        WorldCreator worldCreator = new WorldCreator(worldName);
        return worldCreator.createWorld();
    }
}
