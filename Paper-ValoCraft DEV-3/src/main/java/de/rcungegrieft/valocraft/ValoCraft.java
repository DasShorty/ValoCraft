package de.rcungegrieft.valocraft;

import de.rcungegrieft.valocraft.commands.subCommands.*;
import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.game.listeners.*;
import de.rcungegrieft.valocraft.commands.StartCommand;
import de.rcungegrieft.valocraft.commands.ValoCraftCommand;
import de.rcungegrieft.valocraft.commands.utils.ValoSubCommandHandler;
import de.rcungegrieft.valocraft.game.weapon.listeners.WeaponInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public final class ValoCraft extends ValoSubCommandHandler {

    private static GameManager valoCraftBehaivorManager;
    private static ValoCraft instance;

    public static ValoCraft getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        instance = this;

        valoCraftBehaivorManager = new GameManager();

        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new WeaponInteractListener(), this);
        pluginManager.registerEvents(new PlayerKillListener(), this);
        pluginManager.registerEvents(new PlayerQuitListener(), this);
        pluginManager.registerEvents(new PlayerFoodLevelListener(), this);
        pluginManager.registerEvents(new MobSpawnListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);

        //Bukkit Commands
        getCommand("valo").setExecutor(new ValoCraftCommand());
        getCommand("start").setExecutor(new StartCommand());


        //Sub Commands
        registerSubCommand("setspawn", new ValoSetTeamPosSubCommand());
        registerSubCommand("setteam", new ValoSetPlayerTeamSubCommand());
        registerSubCommand("forcestart", new ValoForceStartSubCommand());
        registerSubCommand("placespike", new ValoPlaceSpikeSubCommand());
        registerSubCommand("build", new ValoBuildSubCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
