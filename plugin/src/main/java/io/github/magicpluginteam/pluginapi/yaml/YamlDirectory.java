package io.github.magicpluginteam.pluginapi.yaml;

import io.github.magaicpluginteam.alert.*;
import io.github.magaicpluginteam.alert.serialize.*;
import io.github.magicpluginteam.pluginapi.Plugin;
import io.github.magicpluginteam.serialize.*;
import io.github.magicpluginteam.serialize.injector.YamlFile;
import io.github.magicpluginteam.serialize.injector.YamlInjector;
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
            ActionBarMessageSerialize.class,
            ChatMessageSerialize.class,
            ClickMessageSerialize.class,
            HoverMessageSerialize.class,
            SoundMessageSerialize.class,
            TitleMessageSerialize.class
    })
    public YamlSection<Message> alerts;

    public YamlDirectory(Plugin plugin) {
        YamlInjector.inject(this, plugin.getDataFolder());
    }

}
