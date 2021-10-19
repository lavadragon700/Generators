package me.lavadragon700.generators.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.List;

public class Color
{
    public static String convert(String s)
    {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static List<String> convert(List<String> s)
    {
        for(String i: s)
        {
            int index = s.indexOf(i);
            s.set(index, ChatColor.translateAlternateColorCodes('&',i));
        }
        return s;
    }
}
