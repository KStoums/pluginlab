package fr.kstars.pluginslab;

import fr.kstars.pluginslab.commands.*;
import fr.kstars.pluginslab.events.*;
import fr.kstars.pluginslab.guis.navigation.NavigationInventoryClickEvent;
import fr.kstars.pluginslab.guis.navigation.NavigationPlayerInteractEvent;
import fr.kstars.pluginslab.guis.navigation.NavigationPlayerDropItemEvent;
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
        getServer().getPluginManager().registerEvents(new AsyncChatEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerSwapHandItemsEvent(), this);

        // Navigation GUI Events
        getServer().getPluginManager().registerEvents(new NavigationPlayerDropItemEvent(), this);
        getServer().getPluginManager().registerEvents(new NavigationInventoryClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new NavigationPlayerInteractEvent(), this);

        //Commands
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new Spawn());
        Objects.requireNonNull(getCommand("teleport")).setExecutor(new Teleport());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new Heal());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new Feed());
        Objects.requireNonNull(getCommand("kill")).setExecutor(new Kill());
        Objects.requireNonNull(getCommand("gamemode")).setExecutor(new GameMode());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new Fly());
        Objects.requireNonNull(getCommand("kick")).setExecutor(new Kick());
        Objects.requireNonNull(getCommand("worldchange")).setExecutor(new WorldChange());
        Objects.requireNonNull(getCommand("clear")).setExecutor(new Clear());
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginsLab are now disabled!");
    }
}
