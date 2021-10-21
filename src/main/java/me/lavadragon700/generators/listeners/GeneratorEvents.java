package me.lavadragon700.generators.listeners;

import me.lavadragon700.generators.Generators;
import me.lavadragon700.generators.generator.Generator;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static me.lavadragon700.generators.Generators.plugin;

public class GeneratorEvents implements Listener
{
    @EventHandler
    public void placeGenerator(BlockPlaceEvent e)
    {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if(e.getItemInHand() == null || e.getItemInHand().getItemMeta() == null)
            return;

        if(plugin.getGenerator(e.getItemInHand().getItemMeta().getDisplayName()) == null)
            return;

        ItemStack item = e.getItemInHand();

        for(Map.Entry<Player, ArrayList<Generator>> entry: plugin.placedGens.entrySet())
        {
            List gens = entry.getValue();

            gens.add(plugin.getGenerator(item.getItemMeta().getDisplayName()));
            String data = b.getX() + ":" + b.getY() + ":" + b.getZ() +  ":" + plugin.getGenerator(item.getItemMeta().getDisplayName()).getName();

            plugin.generator.getConfig().set(p.getUniqueId().toString(), data);
            plugin.generator.save();
        }
    }
}
