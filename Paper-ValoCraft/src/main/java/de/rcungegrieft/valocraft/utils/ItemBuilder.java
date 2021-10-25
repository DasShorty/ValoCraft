/*

    Project : de.rcungegrieft.valocraft.utils
    Class Coder : RCUngegrieft
    Date : Samstag Oktober 2021
    Time : 19:35 Uhr

*/


package de.rcungegrieft.valocraft.utils;

import com.google.common.collect.Multimap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
        this.meta = this.item.getItemMeta();
    }

    public ItemBuilder setDisplayName(String displayName) {
        this.meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        return this;
    }

    public ItemBuilder setLore(String... lore) {
        this.meta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        this.meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.item.setAmount(amount);
        return this;
    }

    public ItemBuilder setData(MaterialData data) {
        this.item.setData(data);
        return this;
    }

    public ItemBuilder setLocalizedName(String localizedName) {
        this.meta.setLocalizedName(localizedName);
        return this;
    }

    public ItemBuilder hideAllItemFlags() {

        this.meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        this.meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        this.meta.addItemFlags(ItemFlag.HIDE_DYE);
        this.meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        this.meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        return this;
    }

    public ItemBuilder setAttributeModifiers(Multimap<Attribute, AttributeModifier> multimap) {
        this.meta.setAttributeModifiers(multimap);
        return this;
    }
    public ItemBuilder addAttribute(Attribute attribute, AttributeModifier attributeModifier) {
        this.meta.addAttributeModifier(attribute, attributeModifier);
        return this;
    }
    public ItemStack buildToItemStack() {
        this.item.setItemMeta(this.meta);
        return this.item;
    }
}