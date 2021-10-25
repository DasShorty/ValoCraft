/*

    Project : de.rcungegrieft.valocraft.config
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 19:58 Uhr

*/


package de.rcungegrieft.valocraft.config.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class ConfigBuilder {

    protected String fileName;
    protected FileConfiguration config;
    File dir;
    File file;
    public ConfigBuilder(String fileName) {

        dir = new File("./plugins/ValoCraft");
        file = new File(dir, fileName);

        if (!dir.exists())
            dir.mkdirs();

        if (!file.exists()) {
            try {
                file.createNewFile();
                this.config = YamlConfiguration.loadConfiguration(file);
                createConfigData();
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.config = YamlConfiguration.loadConfiguration(file);

    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveFile() {
        try {
            this.config.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void createConfigData();
}
