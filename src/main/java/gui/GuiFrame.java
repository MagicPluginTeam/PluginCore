package gui;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public interface GuiFrame {
    void openInventory(Player player);

    void slot(int x, int y, Consumer<InventoryClickEvent> onClick);
    void slot(int x, int y, ItemStack itemStack, Consumer<InventoryClickEvent> onClick);

    void item(int x, int y, ItemStack itemStack);

    ItemStack item(int x, int y);

}
