/*

    Project : de.rcungegrieft.valocraft.utils.message
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 19:29 Uhr

*/


package de.rcungegrieft.valocraft.utils.message;

public enum PrefixType {

    SHORT("§8[§cVC§8]"),
    LONG("§8[§cValoCraft§8]"),
    NONE("");

    private String prefix;

    PrefixType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
