/*

    Project : de.rcungegrieft.valocraft.game.weapon.listeners
    Class Coder : RCUngegrieft
    Date : Montag Oktober 2021
    Time : 20:05 Uhr

*/


package de.rcungegrieft.valocraft.game.weapon.listeners;

import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.game.GameState;
import de.rcungegrieft.valocraft.game.weapon.weapons.Pistol;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WeaponInteractListener implements Listener {


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (!(GameManager.getInstance().getGameState() == GameState.RUNNING)) return;

        if(GameManager.getInstance().getDataStorage().getBuilders().contains(player.getUniqueId())) return;

        if (event.getItem() == null) return;
        ItemStack item = event.getItem();

        switch (item.getType()) {

            case TIPPED_ARROW:

                Pistol pistol = GameManager.getInstance().getWeapons().getPistol();

                FileConfiguration config = GameManager.getInstance().getConfigHandler().getAmmoConfig().getConfig();
                if (!config.contains(player.getUniqueId() + pistol.getWeaponName())) {
                    config.set(player.getUniqueId() + pistol.getWeaponName(), 10);
                    GameManager.getInstance().getConfigHandler().getAmmoConfig().saveFile();
                }

                int ammo = config.getInt(player.getUniqueId() + pistol.getWeaponName());

                if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                    ammo = 10;
                } else {
                    if (ammo == 0) {
                        player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§cKeine Munition mehr! (Nachladen)"));
                        return;
                    }

                    ammo -= 1;
                    pistol.shot(player);
                }

                config.set(player.getUniqueId() + pistol.getWeaponName(), ammo);
                GameManager.getInstance().getConfigHandler().getAmmoConfig().saveFile();
                break;

        }

    }
}
