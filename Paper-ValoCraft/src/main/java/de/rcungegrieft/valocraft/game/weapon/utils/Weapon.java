/*

    Project : de.rcungegrieft.valocraft.game.utils
    Class Coder : RCUngegrieft
    Date : Montag Oktober 2021
    Time : 19:50 Uhr

*/


package de.rcungegrieft.valocraft.game.weapon.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public abstract class Weapon {

    protected WeaponLook weaponLook;
    protected WeaponType weaponType;
    protected Material material;
    protected String weaponName;
    int ammoSize = 10;

    public Weapon(WeaponType weaponType, WeaponLook weaponLook, Material material, String weaponName) {
        this.weaponLook = weaponLook;
        this.weaponType = weaponType;
        this.material = material;
        this.weaponName = weaponName;

    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getAmmoSize() {
        return ammoSize;
    }

    public void setAmmoSize(int ammoSize) {
        this.ammoSize = ammoSize;
    }

    public abstract void shot(Player player);
}
