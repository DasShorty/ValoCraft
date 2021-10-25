/*

    Project : de.rcungegrieft.valocraft.scoreboard
    Class Coder : RCUngegrieft
    Date : Freitag Oktober 2021
    Time : 14:48 Uhr

*/


package de.rcungegrieft.valocraft.scoreboard;

import de.rcungegrieft.valocraft.ValoCraft;
import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.game.GameState;
import de.rcungegrieft.valocraft.utils.Stats;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TeamBoard extends ScoreboardBuilder {



    public TeamBoard(Player player) {
        super(player, PrefixType.LONG.getPrefix());
        run();
    }

    @Override
    public void createScoreboard() {
        Stats playerStats = new Stats(player);
        setScore(ChatColor.BLUE.toString(), 11);
        setScore(" §cTeam", 10);
        setScore("  §7Noch kein Team", 9);
        setScore(ChatColor.RED.toString(), 8);
        setScore(" §cSpieler", 7);
        setScore("  §7" + Bukkit.getOnlinePlayers().size(), 6);
        setScore(ChatColor.YELLOW.toString(), 5);
        setScore(" §cStats", 4);
        setScore("  §7Kills §e" + playerStats.getKills(), 3);
        setScore("  §7Deaths §e" + playerStats.getDeaths(), 2);
        setScore("  §7Wins §e" + playerStats.getWins(), 1);
        setScore(ChatColor.BLUE.toString(), 0);

    }

    @Override
    public void update() {

        if (GameManager.getInstance().getGameState() == GameState.RUNNING) {
            Stats playerStats = new Stats(player);
            if (GameManager.getInstance().getTeamManager().getRedTeam().contains(player.getUniqueId())) {

                setScore(ChatColor.BLUE.toString(), 11);
                setScore(" §cTeam", 10);
                setScore("  §4Rot", 9);
                setScore(ChatColor.RED.toString(), 8);
                setScore(" §cTeamanzahl", 7);
                setScore("  §7" + GameManager.getInstance().getTeamManager().getRedTeam().size(), 6);
                setScore(ChatColor.YELLOW.toString(), 5);
                setScore(" §cStats", 4);
                setScore("  §7Kills §e" + playerStats.getKills(), 3);
                setScore("  §7Deaths §e" + playerStats.getDeaths(), 2);
                setScore("  §7Wins §e" + playerStats.getWins(), 1);
                setScore(ChatColor.BLUE.toString(), 0);

            } else if (GameManager.getInstance().getTeamManager().getBlueTeam().contains(player.getUniqueId())) {

                setScore(ChatColor.BLUE.toString(), 11);
                setScore(" §cTeam", 10);
                setScore("  §3Blau", 9);
                setScore(ChatColor.RED.toString(), 8);
                setScore(" §cSpieler", 7);
                setScore("  §7" + GameManager.getInstance().getTeamManager().getBlueTeam().size(), 6);
                setScore(ChatColor.YELLOW.toString(), 5);
                setScore(" §cStats", 4);
                setScore("  §7Kills §e" + playerStats.getKills(), 3);
                setScore("  §7Deaths §e" + playerStats.getDeaths(), 2);
                setScore("  §7Wins §e" + playerStats.getWins(), 1);
                setScore(ChatColor.BLUE.toString(), 0);

            } else {

                setScore(ChatColor.BLUE.toString(), 11);
                setScore(" §cTeam", 10);
                setScore("  §7Spectator", 9);
                setScore(ChatColor.RED.toString(), 8);
                setScore(" §7Du bist", 7);
                setScore("  §cAusgeschieden!", 6);
                setScore(ChatColor.YELLOW.toString(), 5);
                setScore(" §cStats", 4);
                setScore("  §7Kills §e" + playerStats.getKills(), 3);
                setScore("  §7Deaths §e" + playerStats.getDeaths(), 2);
                setScore("  §7Wins §e" + playerStats.getWins(), 1);
                setScore(ChatColor.BLUE.toString(), 0);

            }

        }

    }

    private void run() {

        new BukkitRunnable() {
            @Override
            public void run() {

                update();

            }
        }.runTaskTimer(ValoCraft.getInstance(), 0, 100);

    }

}
