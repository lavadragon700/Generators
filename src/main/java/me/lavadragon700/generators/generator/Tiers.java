package me.lavadragon700.generators.generator;

import me.lavadragon700.generators.utils.YamlConfig;

import java.util.ArrayList;
import java.util.List;

public class Tiers
{
    private YamlConfig config;
    private List<String> tierList;

    public Tiers(YamlConfig config)
    {
        this.config = config;
        this.tierList = config.getConfig().getStringList("tiers");
    }

    public List<String> getTierList() {
        return config.getConfig().getStringList("tiers");
    }

}
