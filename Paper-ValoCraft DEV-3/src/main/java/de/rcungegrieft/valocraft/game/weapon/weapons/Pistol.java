/*

    Project : de.rcungegrieft.valocraft.game.weapon
    Class Coder : RCUngegrieft
    Date : Montag Oktober 2021
    Time : 19:58 Uhr

*/


package de.rcungegrieft.valocraft.game.weapon.weapons;

import de.rcungegrieft.valocraft.game.GameManager;
import de.rcungegrieft.valocraft.game.weapon.utils.Weapon;
import de.rcungegrieft.valocraft.game.weapon.utils.WeaponLook;
import de.rcungegrieft.valocraft.game.weapon.utils.WeaponType;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

public class Pistol extends Weapon {


    public Pistol() {
        super(WeaponType.SECONDARY, WeaponLook.PISTOL, Material.TIPPED_ARROW, "Pistol");
    }

    @Override
    public void shot(Player player) {


        Arrow arrow = player.launchProjectile(Arrow.class, player.getVelocity());

        if (GameManager.getInstance().getTeamManager().getBlueTeam().contains(player.getUniqueId())) {
            arrow.setColor(Color.BLUE);
        } else {
            arrow.setColor(Color.RED);
        }

        arrow.setGravity(false);
        arrow.setKnockbackStrength(1);
        arrow.setVelocity(player.getLocation().getDirection());
        arrow.setDamage(1D);

        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 3F, 3F);

    }
}
