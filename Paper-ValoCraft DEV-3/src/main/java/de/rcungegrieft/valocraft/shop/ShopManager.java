/*

    Project : de.rcungegrieft.valocraft.shop
    Class Coder : RCUngegrieft
    Date : Sonntag Oktober 2021
    Time : 19:09 Uhr

*/


package de.rcungegrieft.valocraft.shop;

import de.rcungegrieft.valocraft.shop.windows.MainShopMenu;

public class ShopManager {

    private final MainShopMenu mainShopMenu;

    public ShopManager() {

        mainShopMenu = new MainShopMenu();

    }

    public MainShopMenu getMainShopMenu() {
        return mainShopMenu;
    }
}
