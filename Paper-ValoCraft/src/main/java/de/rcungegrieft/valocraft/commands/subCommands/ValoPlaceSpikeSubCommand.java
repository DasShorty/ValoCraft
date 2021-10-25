/*

    Project : de.rcungegrieft.valocraft.commands.subCommands
    Class Coder : RCUngegrieft
    Date : Donnerstag Oktober 2021
    Time : 10:27 Uhr

*/


package de.rcungegrieft.valocraft.commands.subCommands;

import de.rcungegrieft.valocraft.commands.utils.ValoSubCommand;
import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.utils.message.Message;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class ValoPlaceSpikeSubCommand implements ValoSubCommand {


    @Override
    public void performSubCommand(Player player, Command command, String[] args) {

        if (!player.hasPermission("valocraft.command.valo.placespike")) {
            new Message(player).noPermission();
            return;
        }

        GameManager.getInstance().getSpike().placeSpike(player);

        new Message(player).send(PrefixType.LONG, "§7Der Spike wurde platziert!");

    }
}
