/*

    Project : de.rcungegrieft.valocraft.commands
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 20:06 Uhr

*/


package de.rcungegrieft.valocraft.commands;

import de.rcungegrieft.valocraft.commands.utils.ValoSubCommandHandler;
import de.rcungegrieft.valocraft.utils.message.Message;
import de.rcungegrieft.valocraft.utils.message.PrefixType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ValoCraftCommand implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)) {
            new Message(sender).send(PrefixType.SHORT, "§cNur Spieler können diesen Befehl ausführen!");
            return true;
        }

        if(args.length >= 1) {

            Player player = (Player) sender;

            if (!ValoSubCommandHandler.perform(player, command, args)) {
                new Message(sender).send(PrefixType.LONG, "§cDiesen Command gibt es nicht!");
            }

        } else
            new Message(sender).instruction("valo help");

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
       List<String> list = new ArrayList<>();
       if(args.length == 0) return list;
       if(args.length == 1) {
           list.add("setspawn");
           list.add("setteam");
           list.add("forcestart");
           list.add("placespike");
           list.add("build");
       }

       if(args.length == 2) {
           switch (args[0].toLowerCase()) {
               case "setspawn":
                   list.add("red");
                   list.add("blue");
                   break;
               case "setteam":
                   Bukkit.getOnlinePlayers().forEach(player -> {
                       list.add(player.getName());
                   });
                   break;
           }
       }

       if(args.length == 3) {
           switch (args[0].toLowerCase()) {
               case "setteam":

                   list.add("blue");
                   list.add("red");

                   break;
           }
       }

       List<String> completer = new ArrayList<>();
       String current = args[args.length-1];

        for (String s : list) {
            if(s.startsWith(current))
                completer.add(s);
        }

        return completer;
    }
}
