package fr.kstars.pluginslab;

import fr.kstars.pluginslab.commands.*;
import fr.kstars.pluginslab.events.BlockBreakEvent;
import fr.kstars.pluginslab.events.BlockPlaceEvent;
import fr.kstars.pluginslab.events.EntityDamageEvent;
import fr.kstars.pluginslab.events.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PluginsLab are now enabled!");

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
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginsLab are now disabled!");
    }
}
