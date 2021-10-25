/*

    Project : de.rcungegrieft.valocraft.config
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 20:00 Uhr

*/


package de.rcungegrieft.valocraft.config;

import de.rcungegrieft.valocraft.config.utils.ConfigBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationConfig extends ConfigBuilder {


    public LocationConfig() {
        super("locations.yml");
    }


    @Override
    public void createConfigData() {

        config.set("team.red", new Location(Bukkit.getWorld("world"), 0, 24, 0));

    }
}
