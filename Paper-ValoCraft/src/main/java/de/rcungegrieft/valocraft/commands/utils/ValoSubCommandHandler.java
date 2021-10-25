/*

    Project : de.rcungegrieft.valocraft.commands.utils
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 20:07 Uhr

*/


package de.rcungegrieft.valocraft.commands.utils;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ConcurrentHashMap;

public class ValoSubCommandHandler extends JavaPlugin {

    private static final ConcurrentHashMap<String, ValoSubCommand> commands = new ConcurrentHashMap<>();

    public static void registerSubCommand(String command, ValoSubCommand valoSubCommand) {
        commands.put(command, valoSubCommand);
    }

    public static boolean perform(Player player, Command command, String[] args) {
        ValoSubCommand cmd;
        if((cmd = commands.get(args[0])) != null) {
            cmd.performSubCommand(player, command, args);
            return true;
        }
        return false;
    }


}
