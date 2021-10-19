package me.lavadragon700.generators.generator;

import me.lavadragon700.generators.utils.YamlConfig;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.io.File;

import static me.lavadragon700.generators.Generators.plugin;

public class Generator
{
    private String name;
    private YamlConfig config;

    public Generator(YamlConfig config)
    {
        this.config = config;
        this.name = config.getConfig().getString("name");


        plugin.gens.add(this);
    }

    public Generator(String name)
    {
        this.name = name;
        this.config = new YamlConfig(new File(plugin.getDataFolder() + "/Generators"), name);

        plugin.gens.add(this);
    }

    public String getName() {
        return name;
    }

    public YamlConfig getConfig() {
        return config;
    }

    public void setName(String name) {
        this.name = name;
        config.getConfig().set("name", name);
        config.save();
    }
}
