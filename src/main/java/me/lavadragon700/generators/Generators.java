package me.lavadragon700.generators;

import me.lavadragon700.generators.generator.Generator;
import me.lavadragon700.generators.utils.YamlConfig;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public final class Generators extends JavaPlugin
{
    public static Generators plugin;
    public static Permission permission = null;
    public static Economy economy = null;
    public static Chat chat = null;

    public YamlConfig generator = new YamlConfig(getDataFolder(), "PlayersGenerators", true);
    public YamlConfig genDir = new YamlConfig(plugin.getDataFolder(), "GeneratorTypes");

    public Map<Player, ArrayList<Generator>> placedGens = new HashMap<>();

    public Set<Generator> gens = new HashSet<>();

    @Override
    public void onEnable()
    {
        plugin = this;

        this.saveDefaultConfig();

        try{genDir.createSubDirectory(genDir.getName());}catch(IOException e){}

        setupChat();
        setupEconomy();
        setupPermissions();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Generator getGenerator(String name)
    {
        for(Generator i: gens)
        {
            if(i.getName().equalsIgnoreCase(name))
                return i;
        }
        return null;
    }

    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }
        return (chat != null);
    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
        return (economy != null);
    }
}
