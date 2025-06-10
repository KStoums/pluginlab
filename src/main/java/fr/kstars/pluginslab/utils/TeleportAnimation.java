package fr.kstars.pluginslab.utils;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class TeleportAnimation {
    private static final int teleportDelay = 4;

    public static void startTeleportAnimation(JavaPlugin plugin, Player player, Location location) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1000000000,10));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 1000000000,10));

        new BukkitRunnable() {
            Integer teleportDelayCopy = teleportDelay;

            @Override
            public void run() {
                switch (teleportDelayCopy) {
                    case teleportDelay:
                        player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_DOOR_OPEN, 1, 1);
                        break;

                    case 1:
                        player.teleport(location);
                        player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_DOOR_OPEN, 1, 1);
                        break;

                    case 0:
                        player.clearActivePotionEffects();
                        cancel();
                        break;

                    default:
                        player.playSound(player.getLocation(), Sound.BLOCK_GRAVEL_STEP, 1, 1);
                }

                teleportDelayCopy--;
            }
        }.runTaskTimer(plugin, 20L, 20L);
    }
}
