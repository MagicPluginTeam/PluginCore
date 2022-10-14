package io.github.magicpluginteam.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class GuiFrameDSL {

    private final GuiFrameImpl guiFrame;
    GuiFrameDSL(GuiFrameImpl guiFrame) { this.guiFrame = guiFrame; }

    public void openInventory(Player player) {
        guiFrame.openInventory(player);
    }

    public GuiFrameDSL slot(int x, int y, Consumer<InventoryClickEvent> onClick) {
        guiFrame.slot(x, y, onClick);
        return this;
    }

    public GuiFrameDSL slot(int x, int y, ItemStack itemStack, Consumer<InventoryClickEvent> onClick) {
        guiFrame.slot(x, y, itemStack, onClick);
        return this;
    }

}
