package fr.kstars.pluginslab.guis.navigation;

import fr.kstars.pluginslab.models.ItemGui;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Navigation {
    public static final String NavigationMenuName = "§4Navigation Menu";
    public static final String CompassNavigationName = "§4Navigation";

    public static final String LaboratoryItemName = "§4Laboratory";
    public static final String BetterCallSaulOfficeItemName = "§4Better Call Saul Office";
    public static final String LosPollosHermanosItemName = "§4Los Pollos Hermanos";

    public static void openNavigationMenu(Player player) {
        Inventory navigationMenu = Bukkit.createInventory(null, 27, Component.text(NavigationMenuName));

        navigationMenu.setItem(createLosPollosHermanosItem().itemSlot(), createLosPollosHermanosItem().toItemStack());
        navigationMenu.setItem(createLaboratoryItem().itemSlot(), createLaboratoryItem().toItemStack());
        navigationMenu.setItem(createBetterCallSaulItem().itemSlot(), createBetterCallSaulItem().toItemStack());

        player.openInventory(navigationMenu);
    }

    private static ItemGui createLaboratoryItem() {
        return new ItemGui(
                Material.BREWING_STAND,
                LaboratoryItemName,
                "§8The emblematic laboratory from the Breaking Bad series, not to mention the caravan",
                13,
                1);
    }

    private static ItemGui createLosPollosHermanosItem() {
        return new ItemGui(
                Material.COOKED_CHICKEN,
                LosPollosHermanosItemName,
                "§8The Emblematic restaurant from the Breaking Bad series",
                12,
                1);
    }

    private static ItemGui createBetterCallSaulItem() {
        return new ItemGui(
                Material.PAPER,
                BetterCallSaulOfficeItemName,
                "§8Very important place in the Breaking Bad series",
                14,
                1);
    }
}
