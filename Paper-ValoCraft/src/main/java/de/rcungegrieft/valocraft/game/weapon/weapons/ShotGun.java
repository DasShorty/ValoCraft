/*

    Project : de.rcungegrieft.valocraft.game.weapon.weapons
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 18:51 Uhr

*/


package de.rcungegrieft.valocraft.game.weapon.weapons;

import de.rcungegrieft.valocraft.game.weapon.utils.Weapon;
import de.rcungegrieft.valocraft.game.weapon.utils.WeaponLook;
import de.rcungegrieft.valocraft.game.weapon.utils.WeaponType;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ShotGun extends Weapon {


    public ShotGun() {
        super(WeaponType.SECONDARY, WeaponLook.SHOTGUN, Material.COMPASS, "ShotGun");
    }

    @Override
    public void shot(Player player) {



    }
}
