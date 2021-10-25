/*

    Project : de.rcungegrieft.valocraft.commands.subCommands
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 14:11 Uhr

*/


package de.rcungegrieft.valocraft.commands.subCommands;

import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.commands.utils.ValoSubCommand;
import de.rcungegrieft.valocraft.utils.message.Message;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class ValoSetTeamPosSubCommand implements ValoSubCommand {

    @Override
    public void performSubCommand(Player player, Command command, String[] args) {

        if(!(player.hasPermission("valocraft.command.valo.setteam") || player.hasPermission("valocraft.command.valo"))) {
            new Message(player).noPermission();
            return;
        }

        if (args.length == 2) {

            switch (args[1].toLowerCase()) {
                case "blue":

                    GameManager.getInstance().getConfigHandler().getLocationConfig().getConfig().set("team.blue", player.getLocation());
                    GameManager.getInstance().getConfigHandler().getLocationConfig().saveFile();
                    new Message(player).send(PrefixType.SHORT, "Der Spawn von §3Blau §7ist nun auf deiner Position!");

                    break;

                case "red":

                    GameManager.getInstance().getConfigHandler().getLocationConfig().getConfig().set("team.red", player.getLocation());
                    GameManager.getInstance().getConfigHandler().getLocationConfig().saveFile();
                    new Message(player).send(PrefixType.SHORT, "Der Spawn von §cRot §7ist nun auf deiner Position!");

                    break;

                default:
                    new Message(player).instruction("valo setspawn <blue/red>");
                    System.out.println(1);
                    break;
            }

        } else
            new Message(player).instruction("valo setspawn <blue/red>");

    }
}
