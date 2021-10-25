/*

    Project : de.rcungegrieft.valocraft.tablist
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 19:21 Uhr

*/


package de.rcungegrieft.valocraft.tablist;

import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.game.GameState;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TabList {

    public void setHeaderFooter(Player player) {

        if (GameManager.getInstance().getGameState() == GameState.RUNNING) {
            player.sendPlayerListHeaderAndFooter(Component.text("§8-----§8[§cVALOCRAFT§8]§8-----\n§6play.rcungegrieft.de\n "),
                    Component.text("§8----------------------------------------------\n" +
                            "§9Coins §b" + GameManager.getInstance().getDataStorage().getPlayerCoins().get(player.getUniqueId()).getCoins()+"\n" +
                            "\n" +
                            "§6play.rcungegrieft.de §71.16.5 \n" +
                            "§8----------------------------------------------"));

        } else {
            player.sendPlayerListHeaderAndFooter(Component.text("§8-----§8[§cVALOCRAFT§8]§8-----\n§6play.rcungegrieft.de\n "),
                    Component.text("§8----------------------------------------------\n" +
                            "§9Wartemodus\n" +
                            "\n" +
                            "§6play.rcungegrieft.de §71.16.5 \n" +
                            "§8----------------------------------------------"));
        }
    }

    public void setAllTabList() {
        if(Bukkit.getOnlinePlayers().size() == 0) return;
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeams);
        Bukkit.getOnlinePlayers().forEach(this::setHeaderFooter);
    }

    private void setPlayerTeams(Player player) {
        Scoreboard scoreboard = player.getScoreboard();

        if (GameManager.getInstance().getGameState() != GameState.RUNNING) {
            Team normal = scoreboard.getTeam("normal");
            if(normal == null) {
                normal = scoreboard.registerNewTeam("normal");
            }

            normal.color(NamedTextColor.DARK_AQUA);
            normal.addEntry(player.getName());
        } else {
            if(GameManager.getInstance().getTeamManager().getBlueTeam().contains(player.getUniqueId())) {
                Team blue = scoreboard.getTeam("blue");
                if(blue == null) {
                    blue = scoreboard.registerNewTeam("blue");
                }
                blue.color(NamedTextColor.BLUE);
                blue.addEntry(player.getName());
            } else {
                Team red = scoreboard.getTeam("red");
                if(red == null) {
                    red = scoreboard.registerNewTeam("red");
                }
                red.color(NamedTextColor.RED);
                red.addEntry(player.getName());
            }
        }

    }


}
