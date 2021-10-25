/*

    Project : de.rcungegrieft.valocraft.utils
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 18:32 Uhr

*/


package de.rcungegrieft.valocraft.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DataStorage {

    private final HashMap<UUID, Coins> playerCoins = new HashMap<>();
    private final List<UUID> builders = new ArrayList<>();


    public HashMap<UUID, Coins> getPlayerCoins() {
        return playerCoins;
    }

    public List<UUID> getBuilders() {
        return builders;
    }
}
