/*

    Project : de.rcungegrieft.valocraft.game.utils
    Class Coder : RCUngegrieft
    Date : Mittwoch Oktober 2021
    Time : 16:48 Uhr

*/


package de.rcungegrieft.valocraft.game.utils;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class TeamManager {

    private final List<UUID> redTeam;
    private final List<UUID> blueTeam;
    private final List<UUID> spectatorTeam;

    public TeamManager(List<UUID> redTeam, List<UUID> blueTeam, List<UUID> spectatorTeam) {
        this.spectatorTeam = spectatorTeam;
        this.redTeam = redTeam;
        this.blueTeam = blueTeam;
    }

    public List<UUID> getSpectatorTeam() {
        return spectatorTeam;
    }

    public List<UUID> getRedTeam() {
        return redTeam;
    }

    public List<UUID> getBlueTeam() {
        return blueTeam;
    }

    public boolean isInBlueTeam(Player player) {
        return blueTeam.contains(player.getUniqueId());
    }

    public boolean isInRedTeam(Player player) {
        return redTeam.contains(player.getUniqueId());
    }
}
