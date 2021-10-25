/*

    Project : de.rcungegrieft.valocraft.behaivor.listener
    Class Coder : RCUngegrieft
    Date : Freitag Oktober 2021
    Time : 15:43 Uhr

*/


package de.rcungegrieft.valocraft.game.listeners;

import de.rcungegrieft.valocraft.game.GameManager;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {


    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();


        switch (GameManager.getInstance().getGameState()) {

            case WAITING:

                event.quitMessage(Component.text("§c<< §7" + player.getName()));

                break;

            case RUNNING:

                event.quitMessage(Component.text("§c<< §7" + player.getName() + " §7Da er das Spiel verlassen hat wird ihm eine kleine Strafe erwarten!"));

                break;

            case ENDING:
                event.quitMessage(Component.text(""));
                break;

        }

    }
}
