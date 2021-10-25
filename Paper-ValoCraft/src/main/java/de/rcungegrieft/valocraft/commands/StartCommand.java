/*

    Project : de.rcungegrieft.valocraft.commands
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 14:39 Uhr

*/


package de.rcungegrieft.valocraft.commands;

import de.rcungegrieft.valocraft.ValoCraft;
import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.game.GameState;
import de.rcungegrieft.valocraft.utils.message.Message;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class StartCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!sender.hasPermission("valocraft.command.start")) {
            new Message(sender).noPermission();
            return true;
        }

        if (Bukkit.getOnlinePlayers().size() >= 8) {

            final int[] countDown = {10};

            new BukkitRunnable() {
                @Override
                public void run() {

                    if (countDown[0] == 1) {
                        Bukkit.broadcast(Component.text(PrefixType.SHORT.getPrefix() + " §7Das Spielt beginnt in §6einer §7Sekunde§c!"));
                    } else if (countDown[0] == 0) {
                        Bukkit.broadcast(Component.text(PrefixType.SHORT.getPrefix() + " §7Das Spielt beginnt jetzt§c!"));
                    } else
                        Bukkit.broadcast(Component.text(PrefixType.SHORT.getPrefix() + " §7Das Spielt beginnt in §6" + countDown + " §7Sekunden§c!"));

                    countDown[0]--;

                    if (countDown[0] == -1) {

                        GameManager.getInstance().setGameState(GameState.RUNNING);
                        GameManager.getInstance().startingGame();
                        this.cancel();

                    }
                }

            }.runTaskTimer(ValoCraft.getInstance(), 0, 20);

        } else
            new Message(sender).send(PrefixType.LONG, "§cEs sind nicht genügend Spieler Online!");

        return true;
    }
}
