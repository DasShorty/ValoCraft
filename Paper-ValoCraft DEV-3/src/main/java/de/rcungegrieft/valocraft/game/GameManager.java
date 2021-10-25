/*

    Project : de.rcungegrieft.valocraft.behaivor.listener
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 19:50 Uhr

*/


package de.rcungegrieft.valocraft.game;

import de.rcungegrieft.valocraft.ValoCraft;
import de.rcungegrieft.valocraft.config.utils.ConfigHandler;
import de.rcungegrieft.valocraft.game.items.Spike;
import de.rcungegrieft.valocraft.game.phase.PhaseManager;
import de.rcungegrieft.valocraft.game.utils.TeamManager;
import de.rcungegrieft.valocraft.game.weapon.Weapons;
import de.rcungegrieft.valocraft.tablist.TabList;
import de.rcungegrieft.valocraft.utils.Coins;
import de.rcungegrieft.valocraft.utils.DataStorage;
import de.rcungegrieft.valocraft.utils.message.Message;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class GameManager {

    private static GameManager instance;
    private final ConfigHandler configHandler;
    private final Weapons weapons;
    private final DataStorage dataStorage;
    private final TeamManager teamManager;
    private final PhaseManager phaseManager;
    private GameState gameState = GameState.WAITING;
    private Spike spike;

    public GameManager() {
        instance = this;
        teamManager = new TeamManager(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        dataStorage = new DataStorage();
        configHandler = new ConfigHandler();
        weapons = new Weapons();

        phaseManager = new PhaseManager();

        spike = new Spike();

        thread();
        waitingMessage();

        Bukkit.getWorlds().forEach(world -> {
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
            world.setThundering(false);
            world.setStorm(false);
            world.setDifficulty(Difficulty.NORMAL);
            world.setGameRule(GameRule.NATURAL_REGENERATION, false);
            world.setTime(1000L);
        });
    }

    public static GameManager getInstance() {
        return instance;
    }

    public Spike getSpike() {
        return spike;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public DataStorage getDataStorage() {
        return dataStorage;
    }

    public PhaseManager getPhaseManager() {
        return phaseManager;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public ConfigHandler getConfigHandler() {
        return configHandler;
    }

    public void thread() {
        new BukkitRunnable() {
            @Override
            public void run() {
                new TabList().setAllTabList();
            }

        }.runTaskTimer(ValoCraft.getInstance(), 0, 20);
    }

    public void startingGame() {

        Location teamRedSpawn = configHandler.getLocationConfig().getConfig().getLocation("team.red");
        Location teamBlueSpawn = configHandler.getLocationConfig().getConfig().getLocation("team.blue");

        assert teamBlueSpawn != null;


        Player[] players = Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]);

        Player[] teamRed = {players[4], players[5], players[6], players[7]};

        Player[] teamBlue = {players[0], players[1], players[2], players[3]};

        for (Player player : teamBlue) {
            teamManager.getBlueTeam().add(player.getUniqueId());
            player.teleport(teamBlueSpawn);
            new Message(player).send(PrefixType.LONG, "§7Du wurdest zu deinem TeamManager Spawn Teleportiert!");

            Coins coins = new Coins(player);
            coins.setCoins(100);

            dataStorage.getPlayerCoins().put(player.getUniqueId(), coins);

        }

        for (Player player : teamRed) {
            teamManager.getRedTeam().add(player.getUniqueId());
            player.teleport(teamRedSpawn);
            new Message(player).send(PrefixType.LONG, "§7Du wurdest zu deinem TeamManager Spawn Teleportiert!");

            Coins coins = new Coins(player);
            coins.setCoins(100);

            dataStorage.getPlayerCoins().put(player.getUniqueId(), coins);

        }


    }

    public void waitingMessage() {
        new BukkitRunnable() {
            @Override
            public void run() {

                if (gameState == GameState.RUNNING) {
                    this.cancel();
                    return;
                }

                if (!(Bukkit.getOnlinePlayers().size() < 1)) {
                    Bukkit.broadcast(Component.text(PrefixType.SHORT.getPrefix() + " §7Warten auf weitere Spieler §c" + Bukkit.getOnlinePlayers().size() + "§8/§c8§7."));
                }

            }

        }.runTaskTimer(ValoCraft.getInstance(), 0, 2400);
    }

}
