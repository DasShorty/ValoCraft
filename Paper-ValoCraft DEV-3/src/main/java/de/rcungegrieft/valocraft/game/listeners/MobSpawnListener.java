/*

    Project : de.rcungegrieft.valocraft.game.listeners
    Class Coder : RCUngegrieft
    Date : Donnerstag Oktober 2021
    Time : 11:34 Uhr

*/


package de.rcungegrieft.valocraft.game.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobSpawnListener implements Listener {


    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        event.setCancelled(true);
    }
}
