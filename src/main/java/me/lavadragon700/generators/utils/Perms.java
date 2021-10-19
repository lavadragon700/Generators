package me.lavadragon700.generators.utils;

import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public enum Perms
{
    ALL_PERMS("generator.*"),
    CREATE_GENERATOR("generator.create");

    private Permission perm;

    Perms(String perm)
    {
        this.perm = new Permission(perm);
    }

    public boolean hasPerm(Player p)
    {
        return p.hasPermission(this.perm);
    }
}
