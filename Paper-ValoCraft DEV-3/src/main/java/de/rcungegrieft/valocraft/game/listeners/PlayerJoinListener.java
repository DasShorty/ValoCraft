/*

    Project : de.rcungegrieft.valocraft.behaivor.listener
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 19:47 Uhr

*/


package de.rcungegrieft.valocraft.game.listeners;


import de.rcungegrieft.valocraft.ValoCraft;
import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.config.StatsConfig;
import de.rcungegrieft.valocraft.game.GameState;
import de.rcungegrieft.valocraft.scoreboard.TeamBoard;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        switch (GameManager.getInstance().getGameState()) {
            case WAITING: {
                event.joinMessage(Component.text("§a>> §7" + player.getName()));

                if(!GameManager.getInstance().getConfigHandler().getStatsConfig().getConfig().contains(player.getUniqueId().toString())) {
                    StatsConfig statsConfig = GameManager.getInstance().getConfigHandler().getStatsConfig();
                    statsConfig.getConfig().set(player.getUniqueId() + ".kills", 0);
                    statsConfig.getConfig().set(player.getUniqueId() + ".deaths", 0);
                    statsConfig.getConfig().set(player.getUniqueId() + ".wins", 0);
                    statsConfig.saveFile();
                }

                new TeamBoard(player);

                if (Bukkit.getOnlinePlayers().size() == 8) {
                    final int[] countDown = {10};

                    GameManager.getInstance().setGameState(GameState.RUNNING);

                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            if (countDown[0] == 1) {
                                Bukkit.broadcast(Component.text(PrefixType.SHORT.getPrefix() + " §7Das Spielt beginnt in §6einer §7Sekunde§c!"));
                            } else if (countDown[0] == 0) {
                                Bukkit.broadcast(Component.text(PrefixType.SHORT.getPrefix() + " §7Das Spielt beginnt jetzt§c!"));
                            } else
                                Bukkit.broadcast(Component.text(PrefixType.SHORT.getPrefix() + " §7Das Spielt beginnt in §6" + countDown + " §7Sekunden§c!"));

                            countDown[0]--;

                            if(Bukkit.getOnlinePlayers().size() < 8) {

                                GameManager.getInstance().setGameState(GameState.WAITING);
                                this.cancel();

                            }

                            if (countDown[0] == -1) {

                                GameManager.getInstance().startingGame();
                                this.cancel();

                            }
                        }

                    }.runTaskTimer(ValoCraft.getInstance(), 0, 20);
                }

                break;
            }

            case RUNNING: {
                event.joinMessage(Component.text(""));
                player.kick(Component.text("§cDas Spiel läuft bereits!"), PlayerKickEvent.Cause.PLUGIN);
                break;
            }

            case ENDING: {
                event.joinMessage(Component.text(""));
                player.kick(Component.text("§cDer Server wird gleich neugestartet!"), PlayerKickEvent.Cause.PLUGIN);
                break;
            }
        }

    }
}
