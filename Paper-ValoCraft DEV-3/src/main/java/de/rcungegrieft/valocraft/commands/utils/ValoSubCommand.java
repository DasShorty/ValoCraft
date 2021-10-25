/*

    Project : de.rcungegrieft.valocraft.commands
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 20:06 Uhr

*/


package de.rcungegrieft.valocraft.commands.utils;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public interface ValoSubCommand {

    public void performSubCommand(Player player, Command command, String[] args);


}
