package me.lavadragon700.generators;

import org.bukkit.plugin.java.JavaPlugin;

public final class Generators extends JavaPlugin {

    public static Generators plugin;

    @Override
    public void onEnable()
    {
        int a = 0;
        plugin = this;
        this.saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
