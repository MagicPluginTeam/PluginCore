package io.github.magicpluginteam.gui;

import io.github.magicpluginteam.gui.utils.Function3;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
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

    public GuiFrameDSL onClick(Function3<Integer, Integer, InventoryClickEvent> onClick) {
        guiFrame.onClick = onClick;
        return this;
    }

    public GuiFrameDSL onOpen(Consumer<InventoryOpenEvent> onOpen) {
        guiFrame.onOpen = onOpen;
        return this;
    }

    public GuiFrameDSL onClose(Consumer<InventoryCloseEvent> onClose) {
        guiFrame.onClose = onClose;
        return this;
    }

    public GuiFrameDSL onClickBottom(Consumer<InventoryClickEvent> onClickBottom) {
        guiFrame.onClickBottom = onClickBottom;
        return this;
    }

    public GuiFrameDSL onClickOutside(Consumer<InventoryClickEvent> onClickOutside) {
        guiFrame.onClickOutside = onClickOutside;
        return this;
    }





}
