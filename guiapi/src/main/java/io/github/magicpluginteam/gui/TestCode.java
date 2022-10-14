package io.github.magicpluginteam.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class TestCode {
    public static void testCodeUsage(Plugin plugin, Player player) {
        ItemStack apple = new ItemStack(Material.APPLE);
        Gui.frame(plugin, 6, "Hello")
                .slot(0, 0, apple, event -> event.getWhoClicked().sendMessage("Yo!"))
                .slot(0, 1, event -> event.getWhoClicked().sendMessage("Yeah!"))
                .openInventory(player);
    }

}
