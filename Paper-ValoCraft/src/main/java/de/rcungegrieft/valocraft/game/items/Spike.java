/*

    Project : de.rcungegrieft.valocraft.game.items
    Class Coder : RCUngegrieft
    Date : Mittwoch Oktober 2021
    Time : 16:46 Uhr

*/


package de.rcungegrieft.valocraft.game.items;

import de.rcungegrieft.valocraft.ValoCraft;
import de.rcungegrieft.valocraft.game.GameManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Collection;

public class Spike {

    int countdown = 11;
    private Location location;
    private Block block;
    private Player player;
    private BossBar bar;
    private BukkitTask task;
    private boolean isPlaced = false;

    public Location getLocation() {
        return location;
    }

    public Block getBlock() {
        return block;
    }

    public Player getPlayer() {
        return player;
    }

    public void breakSpike() {
        task.cancel();
        bar.removeAll();
        Bukkit.getOnlinePlayers().forEach(players -> {

            players.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§7Der Spike wurde entschärft!"));
            players.playSound(players.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 20F, 2F);


        });
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void placeSpike(Player player) {

        this.player = player;
        this.location = player.getLocation();
        this.block = this.location.getBlock();

        this.isPlaced = true;

        Block block = location.getBlock();
        block.setType(Material.BEACON);
        if (GameManager.getInstance().getTeamManager().getBlueTeam().contains(player.getUniqueId())) {
            bar = Bukkit.createBossBar("§6Spike", BarColor.BLUE, BarStyle.SOLID, BarFlag.DARKEN_SKY);
            Bukkit.getOnlinePlayers().forEach(bar::addPlayer);
        } else {
            bar = Bukkit.createBossBar("§6Spike", BarColor.RED, BarStyle.SOLID, BarFlag.DARKEN_SKY);
            Bukkit.getOnlinePlayers().forEach(bar::addPlayer);
        }
        run();
    }

    private void run() {
        task = (new BukkitRunnable() {

            @Override
            public void run() {

                countdown--;

                if (countdown == -1) {
                    this.cancel();
                }

                switch (countdown) {
                    case 10: {
                        Collection<Player> nearbyPlayers = location.getNearbyPlayers(5);
                        bar.setProgress(1.0);
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            if (!nearbyPlayers.contains(player)) {
                                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 30F, 1F);
                                player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§CDer Spike wurde Platziert!"));
                            }
                        });

                        nearbyPlayers.forEach(players -> {

                            players.playSound(players.getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 100F, 0F);

                        });

                        break;
                    }
                    case 9:
                        bar.setProgress(0.9D);
                        break;
                    case 8:
                        bar.setProgress(0.8D);
                        break;
                    case 7:
                        bar.setProgress(0.7D);
                        break;
                    case 6:
                        bar.setProgress(0.6D);
                        break;
                    case 5:
                        bar.setProgress(0.5D);

                        Bukkit.getOnlinePlayers().forEach(player -> {

                            player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§cDer Spike explodiert gleich!"));

                        });

                        break;
                    case 4:
                        bar.setProgress(0.4D);
                        break;
                    case 3:
                        bar.setProgress(0.3D);
                        break;
                    case 2:
                        bar.setProgress(0.2D);
                        break;
                    case 1:
                        bar.setProgress(0.1D);
                        break;
                    case 0: {
                        bar.setProgress(0D);

                        Collection<Player> nearbyPlayers = block.getLocation().getNearbyPlayers(1000);
                        Bukkit.getOnlinePlayers().forEach(players -> {
                            if (nearbyPlayers.contains(players)) {

                                players.setHealth(0);

                            }
                        });
                        break;
                    }

                }

            }

        }.runTaskTimer(ValoCraft.getInstance(), 0L, 20L));
    }
}
