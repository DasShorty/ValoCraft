/*

    Project : de.rcungegrieft.valocraft.game.weapon
    Class Coder : RCUngegrieft
    Date : Montag Oktober 2021
    Time : 20:04 Uhr

*/


package de.rcungegrieft.valocraft.game.weapon;

import de.rcungegrieft.valocraft.game.weapon.weapons.Pistol;

public class Weapons {

    private final Pistol pistol;

    public Pistol getPistol() {
        return pistol;
    }

    public Weapons() {
        pistol = new Pistol();

    }
}
