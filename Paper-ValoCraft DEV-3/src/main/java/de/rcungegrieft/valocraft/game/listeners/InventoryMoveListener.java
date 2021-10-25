/*

    Project : de.rcungegrieft.valocraft.game.listeners
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 19:10 Uhr

*/


package de.rcungegrieft.valocraft.game.listeners;

import de.rcungegrieft.valocraft.game.GameManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryMoveListener implements Listener {


    @EventHandler
    public void onInventoryMoveItem(InventoryClickEvent event) {

        if(!(event.getWhoClicked() instanceof Player)) return;

        Player player = ((Player) event.getWhoClicked());

        if (GameManager.getInstance().getDataStorage().getBuilders().contains(player.getUniqueId())) return;

            event.setCancelled(true);

    }
}
