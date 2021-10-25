/*

    Project : de.rcungegrieft.valocraft.commands.subCommands
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 18:55 Uhr

*/


package de.rcungegrieft.valocraft.commands.subCommands;

import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.commands.utils.ValoSubCommand;
import de.rcungegrieft.valocraft.utils.message.Message;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class ValoSetPlayerTeamSubCommand implements ValoSubCommand {


    @Override
    public void performSubCommand(Player player, Command command, String[] args) {

        if(args.length == 3) {

            if(Bukkit.getPlayer(args[1]) == null) {
                new Message(player).send(PrefixType.LONG, "§cDer Spieler ist nicht Online!");
                return;
            }

            Player target = Bukkit.getPlayer(args[1]);

            switch (args[2].toLowerCase()) {
                case "red":

                    if(GameManager.getInstance().getTeamManager().getBlueTeam().contains(player.getUniqueId())) {
                        GameManager.getInstance().getTeamManager().getRedTeam().add(target.getUniqueId());
                        GameManager.getInstance().getTeamManager().getBlueTeam().remove(target.getUniqueId());

                        new Message(player).send(PrefixType.LONG, "Der Spieler §3" + player.getName() + " §7ist nun im Team §4Rot");
                    } else {
                        GameManager.getInstance().getTeamManager().getRedTeam().add(target.getUniqueId());

                        new Message(player).send(PrefixType.LONG, "Der Spieler §3" + player.getName() + " §7ist nun im Team §4Rot");
                    }
                    break;

                case "blue":

                    if(GameManager.getInstance().getTeamManager().getBlueTeam().contains(target.getUniqueId())) {
                        GameManager.getInstance().getTeamManager().getRedTeam().remove(target.getUniqueId());
                        GameManager.getInstance().getTeamManager().getBlueTeam().add(target.getUniqueId());

                        new Message(player).send(PrefixType.LONG, "Der Spieler §3" + player.getName() + " §7ist nun im Team §3Blau");
                    } else {
                        GameManager.getInstance().getTeamManager().getBlueTeam().add(target.getUniqueId());

                        new Message(player).send(PrefixType.LONG, "Der Spieler §3" + player.getName() + " §7ist nun im Team §3Blau");
                    }
                    break;
            }

        } else
            new Message(player).instruction("valo setteam <Spieler> <Team>");

    }
}
