package gui;

import gui.utils.Function3;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.function.Consumer;

public class GuiFrameImpl implements GuiWindow, GuiFrame {

    private final ArrayList<GuiSlot> slots = new ArrayList<>();

    private final Inventory inv;
    @NotNull
    @Override
    public Inventory getInventory() { return inv; }

    private Consumer<InventoryOpenEvent> onOpen;
    private Consumer<InventoryCloseEvent> onClose;
    private Function3<Integer, Integer, InventoryClickEvent> onClick;
    private Consumer<InventoryClickEvent> onClickBottom;
    private Consumer<InventoryClickEvent> onClickOutside;

    public GuiFrameImpl(int lines, String title) {
        inv = Bukkit.createInventory(this, lines * 9, title);
    }

    private void assertItemSlot(int x, int y) {
        var lines = inv.getSize() / 9;
        if (0 > x || x >= 9 || 0 > y || y >= lines) {
            throw new AssertionError("require 0 <= x <= 8 0 <= y < " + lines);
        }

    }

    @Override
    public void openInventory(Player player) {
        player.openInventory(getInventory());
    }

    @Override
    public void slot(int x, int y, Consumer<InventoryClickEvent> onClick) {
        assertItemSlot(x, y);
        var guiSlot = new GuiSlot();
        guiSlot.x = x;
        guiSlot.y = y;
        guiSlot.onClick = onClick;
        slots.add(guiSlot);
    }

    @Override
    public void slot(int x, int y, ItemStack itemStack, Consumer<InventoryClickEvent> onClick) {
        assertItemSlot(x, y);
        var guiSlot = new GuiSlot();
        guiSlot.x = x;
        guiSlot.y = y;
        guiSlot.onClick = onClick;
        item(x, y, itemStack);
        slots.add(guiSlot);
    }

    @Override
    public void item(int x, int y, ItemStack itemStack) {
        assertItemSlot(x, y);
        inv.setItem(x + y * 9, itemStack);
    }

    @Override
    public ItemStack item(int x, int y) {
        assertItemSlot(x, y);
        return inv.getItem(x + y * 9);
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        if (onOpen == null) return;
        this.onOpen.accept(event);
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        if (onClose == null) return;
        this.onClose.accept(event);
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        var slot = event.getSlot();
        var x = slot % 9;
        var y = slot / 9;

        if (onClick != null) {
            this.onClick.invoke(x, y, event);
        }

        slots.stream().filter(s -> s.x == x && s.y == y).forEach(s -> {
            if (s.onClick != null) s.onClick.accept(event);
        });
    }

    @Override
    public void onClickBottom(InventoryClickEvent event) {
        event.setCancelled(true);
        if (onClickBottom == null) return;
        onClickBottom.accept(event);
    }

    @Override
    public void onClickOutside(InventoryClickEvent event) {
        event.setCancelled(true);
        if (onClickOutside == null) return;
        onClickOutside.accept(event);
    }

    @Override
    public void onDrag(InventoryDragEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void onPickupItem(EntityPickupItemEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void onDropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }


}
