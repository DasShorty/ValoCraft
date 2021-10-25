/*

    Project : de.rcungegrieft.valocraft.behaivor.listener
    Class Coder : RCUngegrieft
    Date : Freitag Oktober 2021
    Time : 15:31 Uhr

*/


package de.rcungegrieft.valocraft.game.listeners;

import de.rcungegrieft.valocraft.ValoCraft;
import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.game.GameState;
import de.rcungegrieft.valocraft.utils.Stats;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerKillListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player)) return;
        if (!(event instanceof EntityDamageByEntityEvent)) return;
        EntityDamageByEntityEvent damageByEntityEvent = (EntityDamageByEntityEvent) event;

        if (!(GameManager.getInstance().getGameState() == GameState.RUNNING)) {
            event.setCancelled(true);
            return;
        }

        if (damageByEntityEvent.getEntity() instanceof Player) return;

        if (damageByEntityEvent.getDamager().getType() == EntityType.ARROW) {
            Entity entity = damageByEntityEvent.getEntity();
            entity.remove();
        }

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        if (event.getEntity().getKiller() == null) {
            event.deathMessage(Component.text(""));
            spectator(event.getEntity());
            return;
        }

        Player killer = event.getEntity().getKiller();
        Player player = event.getEntity();

        if(GameManager.getInstance().getDataStorage().getBuilders().contains(player.getUniqueId())) return;

        event.deathMessage(Component.text("§3" + player.getName() + " §7ist von §6" + killer.getName() + " §7getötet worden"));

        Stats killerStats = new Stats(killer);
        killerStats.setStats(killerStats.getWins(), killerStats.getKills() + 1, killerStats.getDeaths());

        Stats playerStats = new Stats(player);
        playerStats.setStats(playerStats.getWins(), playerStats.getKills(), playerStats.getDeaths() + 1);

        spectator(player);

    }

    private void spectator(Player player) {
        player.setGameMode(GameMode.ADVENTURE);
        player.setAllowFlight(true);
        player.setFlying(true);

        Bukkit.getOnlinePlayers().forEach(players -> {

            if (GameManager.getInstance().getTeamManager().getSpectatorTeam().contains(players.getUniqueId())) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 250, true, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 250, true, false, false));
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 250, true, false, false));
            } else {
                players.hidePlayer(ValoCraft.getInstance(), player);
            }

        });
    }

}
