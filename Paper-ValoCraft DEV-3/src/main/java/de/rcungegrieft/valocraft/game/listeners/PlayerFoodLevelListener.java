/*

    Project : de.rcungegrieft.valocraft.game.listeners
    Class Coder : RCUngegrieft
    Date : Donnerstag Oktober 2021
    Time : 11:35 Uhr

*/


package de.rcungegrieft.valocraft.game.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class PlayerFoodLevelListener implements Listener {


    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        event.setCancelled(true);
        event.setFoodLevel(20);
    }
}
