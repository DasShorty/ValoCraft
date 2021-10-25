/*

    Project : de.rcungegrieft.valocraft.commands.subCommands
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 18:59 Uhr

*/


package de.rcungegrieft.valocraft.commands.subCommands;

import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.commands.utils.ValoSubCommand;
import de.rcungegrieft.valocraft.game.GameState;
import de.rcungegrieft.valocraft.utils.Coins;
import de.rcungegrieft.valocraft.utils.message.Message;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class ValoForceStartSubCommand implements ValoSubCommand {


    @Override
    public void performSubCommand(Player player, Command command, String[] args) {

        if (GameManager.getInstance().getGameState() != GameState.RUNNING) {
            GameManager.getInstance().setGameState(GameState.RUNNING);
            new Message(player).send(PrefixType.LONG, "§7Das Spiel wurde geforcestartet! §cKeine Teams gesetzt!");

            for (Player player1 : Bukkit.getOnlinePlayers()) {
                Coins coins = new Coins(player1);
                coins.setCoins(100);
                GameManager.getInstance().getDataStorage().getPlayerCoins().put(player1.getUniqueId(), coins);
                player1.setHealthScale(100);
                player1.setHealth(20);
            }

        } else
            new Message(player).send(PrefixType.LONG, "§cDas Spiel läuft bereits!");

    }
}
