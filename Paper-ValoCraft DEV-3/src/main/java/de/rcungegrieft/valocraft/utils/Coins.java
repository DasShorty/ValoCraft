/*

    Project : de.rcungegrieft.valocraft.utils
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 18:31 Uhr

*/


package de.rcungegrieft.valocraft.utils;

import org.bukkit.entity.Player;

public class Coins {

    private Player player;
    private int coins;

    public Coins(Player player) {

        this.player = player;

    }

    public Player getPlayer() {
        return player;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
