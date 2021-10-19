package me.lavadragon700.generators.commands;

import me.lavadragon700.generators.generator.Generator;
import me.lavadragon700.generators.utils.Color;
import me.lavadragon700.generators.utils.Perms;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.lavadragon700.generators.Generators.plugin;

public class GeneratorCmd implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Player p = (Player) sender;
        String permMsg = Color.convert(command.getPermissionMessage());

        switch(args.length)
        {
            /**
             * Generator help menu
             */
            case 0:

            break;

            case 1:
                if(args[0].equalsIgnoreCase(""))
                {

                }
            break;

            case 2:
                /**
                 * @description creates a generator of the name said
                 *
                 * args[1] = name
                 *
                 * Usage: /gen create <name>
                 */
                if(args[0].equalsIgnoreCase("create"))
                {
                    if(!Perms.CREATE_GENERATOR.hasPerm(p))
                    {
                        p.sendMessage(permMsg);
                        return false;
                    }
                    else if(!Perms.ALL_PERMS.hasPerm(p))
                    {
                        p.sendMessage(permMsg);
                        return false;
                    }


                    plugin.gens.add(new Generator(args[1]));
                }
            break;
        }
        return false;
    }
}
