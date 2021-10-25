/*

    Project : de.rcungegrieft.valocraft.utils
    Class Coder : RCUngegrieft
    Date : Freitag Oktober 2021
    Time : 14:54 Uhr

*/


package de.rcungegrieft.valocraft.utils;

import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.config.StatsConfig;
import org.bukkit.entity.Player;

public class Stats {

    private final Player player;

    public Stats(Player player) {

        this.player = player;

    }


    /**
     * @param wins   Siege
     * @param deaths Tode
     * @param kills  Getötete Spieler
     */
    public void setStats(int wins, int kills, int deaths) {

        StatsConfig statsConfig = GameManager.getInstance().getConfigHandler().getStatsConfig();

        statsConfig.getConfig().set(player.getUniqueId() + ".wins", wins);
        statsConfig.getConfig().set(player.getUniqueId() + ".kills", kills);
        statsConfig.getConfig().set(player.getUniqueId() + ".deaths", deaths);

        statsConfig.saveFile();

    }

    public int getKills() {

        StatsConfig statsConfig = GameManager.getInstance().getConfigHandler().getStatsConfig();

        if (statsConfig.getConfig().contains(player.getUniqueId() + ".kills")) {

            return statsConfig.getConfig().getInt(player.getUniqueId() + ".kills");

        }

        return 0;
    }

    public int getDeaths() {

        StatsConfig statsConfig = GameManager.getInstance().getConfigHandler().getStatsConfig();

        if (statsConfig.getConfig().contains(player.getUniqueId() + ".deaths")) {

            return statsConfig.getConfig().getInt(player.getUniqueId() + ".deaths");

        }

        return 0;
    }

    public int getWins() {

        StatsConfig statsConfig = GameManager.getInstance().getConfigHandler().getStatsConfig();

        if (statsConfig.getConfig().contains(player.getUniqueId() + ".wins")) {

            return statsConfig.getConfig().getInt(player.getUniqueId() + ".wins");

        }

        return 0;
    }

}
