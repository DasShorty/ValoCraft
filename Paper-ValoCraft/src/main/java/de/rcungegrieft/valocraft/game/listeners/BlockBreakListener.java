/*

    Project : de.rcungegrieft.valocraft.game.listeners
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 18:27 Uhr

*/


package de.rcungegrieft.valocraft.game.listeners;

import de.rcungegrieft.valocraft.game.GameManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Block block = event.getBlock();
        Player player = event.getPlayer();

        if(block.getType() != Material.BEACON) return;

        if(!GameManager.getInstance().getSpike().isPlaced()) return;

        if(GameManager.getInstance().getTeamManager().isInBlueTeam(player) && GameManager.getInstance().getTeamManager().isInBlueTeam(GameManager.getInstance().getSpike().getPlayer())) {
            event.setCancelled(true);
            player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§cDu kannst deinen Spike nicht abbauen!"));
        }

        if(GameManager.getInstance().getTeamManager().isInRedTeam(player) && GameManager.getInstance().getTeamManager().isInRedTeam(GameManager.getInstance().getSpike().getPlayer())) {
            event.setCancelled(true);
            player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§cDu kannst deinen Spike nicht abbauen!"));
        }

        if(event.getBlock().getLocation() == GameManager.getInstance().getSpike().getLocation()) {

            GameManager.getInstance().getSpike().breakSpike();

        }

    }
}
