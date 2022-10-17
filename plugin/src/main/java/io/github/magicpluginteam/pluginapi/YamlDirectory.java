package io.github.magicpluginteam.pluginapi;

import io.github.magaicpluginteam.alert.*;
import io.github.magicpluginteam.serialize.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class YamlDirectory {

    @YamlFile(name = "config.yml", serializable = SerializablePrimitive.class)
    public YamlSection<Object> config;

    @YamlFile(name = "inventories.yml", serializable = SerializableInventory.class)
    public YamlSection<Inventory> inventories;

    @YamlFile(name = "items.yml", serializable = SerializableItemStack.class)
    public YamlSection<ItemStack> items;

    @YamlFile(name = "alerts.yml", serializable = {
            SerializableActionBarAlert.class,
            SerializableChatAlert.class,
            SerializableClickAlert.class,
            SerializableHoverAlert.class,
            SerializableSoundAlert.class,
            SerializableTitleAlert.class
    })
    public YamlSection<Alert> alerts;

    public YamlDirectory(Plugin plugin) {
        YamlInjector.inject(this, plugin.getDataFolder());
    }

}
