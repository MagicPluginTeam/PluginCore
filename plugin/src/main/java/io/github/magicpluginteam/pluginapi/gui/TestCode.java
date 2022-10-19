package io.github.magicpluginteam.pluginapi.gui;

import io.github.magicpluginteam.gui.Gui;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TestCode implements Listener {

    private final Plugin plugin;

    public TestCode(Plugin plugin) {
        this.plugin = plugin;
    }

    public static void test(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(new TestCode(plugin), plugin);
    }

    public static void testCodeUsage(Plugin plugin, Player player) {
        ItemStack apple = new ItemStack(Material.APPLE);
        Gui.frame(plugin, 6, "Hello")
                .slot(0, 0, apple, event -> event.getWhoClicked().sendMessage("Yo!"))
                .slot(0, 1, event -> event.getWhoClicked().sendMessage("Yeah!"))
                .openInventory(player);
    }

    public static void testPageListGui(Plugin plugin, Player player) {
        int baseNumber = 35;
        Gui.frame(plugin, 6, "Hello")
                .onClickBottom(event -> event.setCancelled(false))
                .list(1, 1, 7, 3, () -> IntStream.range(0, 30).boxed().toList(), i -> new ItemStack(Material.values()[i + baseNumber]), (list, gui) -> {
                    gui
                            .slot(0, 0, new ItemStack(Material.BLUE_STAINED_GLASS_PANE), event -> list.setIndex(list.getIndex() - 1))
                            .slot(8, 0, new ItemStack(Material.BLUE_STAINED_GLASS_PANE), event -> list.setIndex(list.getIndex() + 1));
                })
                .openInventory(player);
    }


    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        testPageListGui(plugin, event.getPlayer());
    }

}
