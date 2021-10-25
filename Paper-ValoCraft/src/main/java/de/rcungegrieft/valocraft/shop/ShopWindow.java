/*

    Project : de.rcungegrieft.valocraft.shop
    Class Coder : RCUngegrieft
    Date : Montag Oktober 2021
    Time : 11:38 Uhr

*/


package de.rcungegrieft.valocraft.shop;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class ShopWindow {

    protected String title;
    private Inventory inventory;

    public ShopWindow(String title) {

        this.title = title;
        this.inventory = Bukkit.createInventory(null, 27, Component.text(title));

    }

    public abstract void setItems();

    public void setItem(int position, ItemStack itemStack) {
        this.inventory.setItem(position, itemStack);
    }

    public void updateInventory() {
        this.inventory.clear();
        setItems();
    }

    public void clearInventory() {
        this.inventory.clear();
    }

}
