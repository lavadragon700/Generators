package me.lavadragon700.generators.generator;

import me.lavadragon700.generators.utils.Color;
import me.lavadragon700.generators.utils.YamlConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.List;

import static me.lavadragon700.generators.Generators.plugin;

public class Generator
{
    private String name;
    private YamlConfig config;
    private Material material;
    private List<String> lore;
    private Tiers tiers;



    public Generator(YamlConfig config)
    {
        this.config = config;
        this.name = Color.convert(config.getConfig().getString("display_name"));
        this.material = Material.matchMaterial(config.getConfig().getString("display_material"));
        this.tiers = new Tiers(config);

        plugin.gens.add(this);
    }

    public Generator(String name)
    {
        this.name = Color.convert(name);
        this.config = new YamlConfig(new File(plugin.getDataFolder() + "/GeneratorTypes"), name);
        plugin.gens.add(this);
    }

    public String getName() {
        return Color.convert(name);
    }

    public YamlConfig getConfig() {
        return config;
    }

    public Material getMaterial() {
        return material;
    }

    public List<String> getLore(){
        return Color.convert(config.getConfig().getStringList("lore"));
    }

    public void setName(String name) {
        this.name = Color.convert(name);
        config.getConfig().set("name", name);
        config.save();
    }

    public void setLore(List<String> lore) {
        this.lore = Color.convert(lore);
        config.getConfig().set("lore", this.lore);
        config.save();
    }

    public ItemStack getItem() {
        ItemStack gen = new ItemStack(material);
        ItemMeta meta = gen.getItemMeta();
        meta.setDisplayName(getName());


        return gen;
    }

    private void setup()
    {
        config.getConfig().set("display_name", getName());
        config.getConfig().set("display_material", getMaterial());


        config.getConfig().set("Tiers", tiers.getTierList());
    }
}


