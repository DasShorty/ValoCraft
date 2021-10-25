/*

    Project : de.rcungegrieft.valocraft.shop.windows
    Class Coder : RCUngegrieft
    Date : Montag Oktober 2021
    Time : 11:46 Uhr

*/


package de.rcungegrieft.valocraft.shop.windows;

import de.rcungegrieft.valocraft.shop.ShopWindow;
import de.rcungegrieft.valocraft.utils.ItemBuilder;
import org.bukkit.Material;

public class MainShopMenu extends ShopWindow {


    public MainShopMenu() {
        super("§cShop");
    }

    @Override
    public void setItems() {

        setItem(13, new ItemBuilder(Material.TIPPED_ARROW)
                .setDisplayName("§7Pistol")
                .setLore("§7Magazin §610",
                        "§7Schaden §65 HP")
                .hideAllItemFlags()
                .buildToItemStack());

    }
}
