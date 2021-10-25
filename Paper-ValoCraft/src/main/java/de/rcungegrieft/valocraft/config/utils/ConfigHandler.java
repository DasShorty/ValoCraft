/*

    Project : de.rcungegrieft.valocraft.config
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 20:02 Uhr

*/


package de.rcungegrieft.valocraft.config.utils;

import de.rcungegrieft.valocraft.config.AmmoConfig;
import de.rcungegrieft.valocraft.config.LocationConfig;
import de.rcungegrieft.valocraft.config.StatsConfig;
import de.rcungegrieft.valocraft.config.WeaponConfig;

public class ConfigHandler {

    private final LocationConfig locationConfig;
    private final WeaponConfig weaponConfig;
    private final StatsConfig statsConfig;
    private final AmmoConfig ammoConfig;

    public ConfigHandler() {
        locationConfig = new LocationConfig();
        weaponConfig = new WeaponConfig();
        statsConfig = new StatsConfig();
        ammoConfig = new AmmoConfig();
    }

    public AmmoConfig getAmmoConfig() {
        return ammoConfig;
    }

    public StatsConfig getStatsConfig() {
        return statsConfig;
    }

    public WeaponConfig getWeaponConfig() {
        return weaponConfig;
    }

    public LocationConfig getLocationConfig() {
        return locationConfig;
    }
}
