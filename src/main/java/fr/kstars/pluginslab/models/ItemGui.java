package fr.kstars.pluginslab.models;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemGui {

    private final Material itemMaterial;
    private final String itemName;
    private final String itemLore;
    private final Integer itemSlot;
    private final Integer itemAmount;

    public ItemGui(Material itemMaterial, String itemName, String itemLore, Integer itemSlot, Integer itemAmount) {
        this.itemMaterial = itemMaterial;
        this.itemName = itemName;
        this.itemLore = itemLore;
        this.itemSlot = itemSlot;
        this.itemAmount = itemAmount;
    }

    public ItemStack toItemStack() {
        ItemStack guiItem = new ItemStack(this.itemMaterial);
        guiItem.setAmount(this.itemAmount);

        ItemMeta guiItemMeta = guiItem.getItemMeta();
        guiItemMeta.displayName(Component.text(this.itemName));
        guiItemMeta.lore(List.of(
                Component.text(this.itemLore)
        ));

        guiItem.setItemMeta(guiItemMeta);
        return guiItem;
    }

    public Material getItemMaterial() {
        return itemMaterial;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemLore() {
        return itemLore;
    }

    public Integer getItemSlot() {
        return itemSlot;
    }

    public Integer getItemAmount() {
        return itemAmount;
    }
}
