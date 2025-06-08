package fr.kstars.pluginlab.commands;

import fr.kstars.pluginlab.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GameMode implements CommandExecutor {

    private final static String GameModeCreative = "creative";
    private final static String GameModeCreativeNumber = "1";

    private final static String GameModeSurvival = "survival";
    private final static String GameModeSurvivalNumber = "2";

    private final static String GameModeAdventure = "adventure";
    private final static String GameModeAdventureNumber = "3";

    private final static String GameModeSpectator = "spectator";
    private final static String GameModeSpectatorNumber = "4";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String message, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length > 2) {
            player.sendMessage("§cUsage: /gamemode <gamemode> <player> [OPTIONAL]");
            return false;
        }

        org.bukkit.GameMode selectedGameMode = null;
        String selectedGameModeName = "";
        switch (args[0].toLowerCase()) {
            case GameModeCreative, GameModeCreativeNumber:
                selectedGameMode = org.bukkit.GameMode.CREATIVE;
                selectedGameModeName = GameModeCreative.toUpperCase();
                break;
            case GameModeSurvival, GameModeSurvivalNumber:
                selectedGameMode = org.bukkit.GameMode.SURVIVAL;
                selectedGameModeName = GameModeSurvival.toUpperCase();
                break;
            case GameModeAdventure, GameModeAdventureNumber:
                selectedGameMode = org.bukkit.GameMode.ADVENTURE;
                selectedGameModeName = GameModeAdventure.toUpperCase();
                break;
            case GameModeSpectator, GameModeSpectatorNumber:
                selectedGameMode = org.bukkit.GameMode.SPECTATOR;
                selectedGameModeName = GameModeSpectator.toUpperCase();
                break;
        }

        if  (selectedGameMode == null) {
            player.sendMessage("§cError: Selected GameMode doesn't exist!");
            return false;
        }

        if (args.length == 2) {
            Player targetPlayer = Bukkit.getPlayer(args[1]);
            if (targetPlayer == null) {
                player.sendMessage("§cError: Player " + args[0] + " not found!");
                return false;
            }

            targetPlayer.setGameMode(selectedGameMode);
            targetPlayer.sendMessage(ChatUtils.PluginMessagePrefix + "§fYour GameMode has been changed to §6" + selectedGameModeName + " §fby an administration member!");
            targetPlayer.playSound(targetPlayer.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_PLACE, 1, 1);

            player.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou have changed §6" + targetPlayer.getName() + " §fGameMode to §6" + selectedGameModeName + "§f!");
            return true;
        }

        player.setGameMode(selectedGameMode);
        player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_PLACE, 1, 1);
        player.sendMessage(ChatUtils.PluginMessagePrefix + "§fYou have changed your GameMode to §6" + selectedGameModeName + "§f!");
        return true;
    }
}
