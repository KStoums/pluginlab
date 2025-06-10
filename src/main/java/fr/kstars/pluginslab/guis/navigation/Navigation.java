package fr.kstars.pluginslab.guis.navigation;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Navigation {
    public static final String NavigationMenuName = "§4§lNavigation Menu";
    public static final String CompassNavigationName = "§4§lNavigation";

    public static final String LaboratoryItemName = "§4§lLaboratory";
    public static final String BetterCallSaulOfficeItemName = "§4§lBetter Call Saul Office";
    public static final String LosPollosHermanosItemName = "§4§lLos Pollos Hermanos";

    public static void openNavigationMenu(Player player) {
        Inventory navigationMenu = Bukkit.createInventory(null, 27, Component.text(NavigationMenuName));

        navigationMenu.setItem(12, createLosPollosHermanosItem());
        navigationMenu.setItem(13, createLaboratoryItem());
        navigationMenu.setItem(14, createBetterCallSaulItem());

        player.openInventory(navigationMenu);
    }

    private static ItemStack createLaboratoryItem() {
        ItemStack laboratoryItem = new ItemStack(Material.BREWING_STAND);
        ItemMeta laboratoryItemMeta = laboratoryItem.getItemMeta();
        laboratoryItemMeta.displayName(Component.text(LaboratoryItemName));
        laboratoryItemMeta.lore(List.of(
                Component.text("§8The emblematic laboratory from the Breaking Bad series, not to mention the caravan")
        ));

        laboratoryItem.setItemMeta(laboratoryItemMeta);
        return  laboratoryItem;
    }

    private static ItemStack createLosPollosHermanosItem() {
        ItemStack chickenItem = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta chickenItemMeta = chickenItem.getItemMeta();
        chickenItemMeta.displayName(Component.text(LosPollosHermanosItemName));
        chickenItemMeta.lore(List.of(
                Component.text("§8Emblematic restaurant from the Breaking Bad series")
        ));

        chickenItem.setItemMeta(chickenItemMeta);
        return  chickenItem;
    }

    private static ItemStack createBetterCallSaulItem() {
        ItemStack paperItem = new ItemStack(Material.PAPER);
        ItemMeta paperItemMeta = paperItem.getItemMeta();
        paperItemMeta.displayName(Component.text(BetterCallSaulOfficeItemName));
        paperItemMeta.lore(List.of(
                Component.text("§8Very important place in the Breaking Bad series")
        ));

        paperItem.setItemMeta(paperItemMeta);
        return  paperItem;
    }
}
