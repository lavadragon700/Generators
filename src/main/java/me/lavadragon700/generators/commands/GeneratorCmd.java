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
                if(args[0].equalsIgnoreCase("help"))
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
                    p.sendMessage(Color.convert("&aGenerator &l" + args[1] + " &r&ahas been created"));
                    return true;
                }
            break;

            case 3:
                /**
                 * @description Sets the generators name
                 *
                 * args[1] = current gen name
                 * args[2] = new name
                 *
                 * Usage: /gen setName <gen-name> <new-name>
                 */
                if(args[0].equalsIgnoreCase("setName"))
                {
                    if(!Perms.GENERATOR_SET_NAME.hasPerm(p))
                    {
                        p.sendMessage(permMsg);
                        return false;
                    }
                    else if(!Perms.GENERATOR_SET_ALL.hasPerm(p))
                    {
                        p.sendMessage(permMsg);
                        return false;
                    }
                    else if(!Perms.ALL_PERMS.hasPerm(p))
                    {
                        p.sendMessage(permMsg);
                        return false;
                    }

                    plugin.getGenerator(args[1]).setName(args[2]);
                    p.sendMessage(Color.convert("&aGenerator &l" + args[1] + "'s &r&ahas been set to &l" + args[2]));
                }
            break;
        }
        return false;
    }
}
