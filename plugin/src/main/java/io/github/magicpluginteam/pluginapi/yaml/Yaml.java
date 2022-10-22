package io.github.magicpluginteam.pluginapi.yaml;

import io.github.magaicpluginteam.message.Message;
import io.github.magaicpluginteam.message.serialize.SerializableMessage;
import io.github.magicpluginteam.serialize.YamlSection;
import io.github.magicpluginteam.serialize.injector.YamlFile;
import io.github.magicpluginteam.serialize.injector.YamlInjector;
import io.github.magicpluginteam.serialize.serialize.SerializableInventory;
import io.github.magicpluginteam.serialize.serialize.SerializableItemStack;
import io.github.magicpluginteam.serialize.serialize.SerializablePrimitive;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.HashMap;

public class Yaml {

    private static final String lang = "lang";

    @YamlFile(serializable = SerializablePrimitive.class)
    public YamlSection<Object> config;

    @YamlFile(serializable = SerializableItemStack.class, relative = lang)
    public HashMap<String, YamlSection<ItemStack>> items;

    @YamlFile(serializable = SerializableInventory.class, relative = lang)
    public HashMap<String, YamlSection<Inventory>> inventories;

    @YamlFile(serializable = SerializableMessage.class, relative = lang)
    public HashMap<String, YamlSection<Message>> messages;

    public Yaml(File file) {
        YamlInjector.inject(this, file);
    }

}
