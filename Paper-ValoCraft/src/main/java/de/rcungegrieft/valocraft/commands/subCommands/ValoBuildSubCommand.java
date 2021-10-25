/*

    Project : de.rcungegrieft.valocraft.commands.subCommands
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 19:16 Uhr

*/


package de.rcungegrieft.valocraft.commands.subCommands;

import de.rcungegrieft.valocraft.commands.utils.ValoSubCommand;
import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.utils.message.Message;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class ValoBuildSubCommand implements ValoSubCommand {


    @Override
    public void performSubCommand(Player player, Command command, String[] args) {

        if(player.hasPermission("valocraft.command.valo.build")) {

            if(GameManager.getInstance().getDataStorage().getBuilders().contains(player.getUniqueId())) {

                GameManager.getInstance().getDataStorage().getBuilders().remove(player.getUniqueId());
                new Message(player).send(PrefixType.LONG, "§7Du kannst nun §cnicht §7mehr Bauen!");

            } else {

                GameManager.getInstance().getDataStorage().getBuilders().add(player.getUniqueId());
                new Message(player).send(PrefixType.LONG, "§7Du kannst nun Bauen!");

            }

        } else
            new Message(player).noPermission();

    }
}
