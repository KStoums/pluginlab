package fr.kstars.pluginslab.models;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public record ItemGui(Material itemMaterial, String itemName, String itemLore, Integer itemSlot, Integer itemAmount) {

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
}
