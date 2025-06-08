package fr.kstars.pluginlab;

import fr.kstars.pluginlab.commands.*;
import fr.kstars.pluginlab.events.BlockBreakEvent;
import fr.kstars.pluginlab.events.BlockPlaceEvent;
import fr.kstars.pluginlab.events.EntityDamageEvent;
import fr.kstars.pluginlab.events.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PluginLab are now enabled!");

        //Events
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceEvent(), this);

        //Commands
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new Spawn());
        Objects.requireNonNull(getCommand("teleport")).setExecutor(new Teleport());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new Heal());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new Feed());
        Objects.requireNonNull(getCommand("kill")).setExecutor(new Kill());
        Objects.requireNonNull(getCommand("gamemode")).setExecutor(new GameMode());
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginLab are now disabled!");
    }
}
