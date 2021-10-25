/*

    Project : de.rcungegrieft.valocraft.scoreboard
    Class Coder : RCUngegrieft
    Date : Freitag Oktober 2021
    Time : 14:47 Uhr

*/


package de.rcungegrieft.valocraft.scoreboard;

import org.bukkit.ChatColor;

public enum EntryName {
    ENTRY_0(0, ChatColor.DARK_PURPLE.toString()),
    ENTRY_1(1, ChatColor.DARK_GRAY.toString()),
    ENTRY_2(2, ChatColor.AQUA.toString()),
    ENTRY_3(3, ChatColor.BLACK.toString()),
    ENTRY_4(4, ChatColor.BOLD.toString()),
    ENTRY_5(5, ChatColor.RESET.toString()),
    ENTRY_6(6, ChatColor.MAGIC.toString()),
    ENTRY_7(7, ChatColor.GREEN.toString()),
    ENTRY_8(8, ChatColor.RED.toString()),
    ENTRY_9(9, ChatColor.LIGHT_PURPLE.toString()),
    ENTRY_10(10, ChatColor.DARK_AQUA.toString()),
    ENTRY_11(11, ChatColor.GRAY.toString());

    private final int entry;
    private final String entryname;

    EntryName(int entry, String entryname) {
        this.entry = entry;
        this.entryname = entryname;
    }

    public String getEntryName() {
        return entryname;
    }

    public int getEntry() {
        return entry;
    }

}
