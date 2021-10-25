/*

    Project : de.rcungegrieft.valocraft.utils
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 19:08 Uhr

*/


package de.rcungegrieft.valocraft.utils.message;

import org.bukkit.command.CommandSender;

public class Message {

    CommandSender sender;

    public Message(CommandSender sender) {
        this.sender = sender;
    }

    public void send(PrefixType prefixType, String message) {
        sender.sendMessage(prefixType.getPrefix() + " §7" + message);
    }

    public void noPermission() {
        sender.sendMessage(PrefixType.LONG.getPrefix() + " §cDu hast keine Rechte auf darauf!");
    }

    public void instruction(String instruction) {
        sender.sendMessage(PrefixType.LONG.getPrefix() + " §7Nutze §8: §6/" + instruction + " §7!");
    }
}
