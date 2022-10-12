package io.github.magicpluginteam.gui;

import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.function.Consumer;

public class GuiSlot {
    int x;
    int y;
    Consumer<InventoryClickEvent> onClick;
}
