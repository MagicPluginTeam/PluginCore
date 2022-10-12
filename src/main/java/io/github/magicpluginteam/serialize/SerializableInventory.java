package io.github.magicpluginteam.serialize;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Inventory;

public class SerializableInventory implements Serializable<Inventory> {
    @Override
    public Inventory deserialize(ConfigurationSection conf) {
        return Bukkit.createInventory(null, conf.getInt("InventorySize"));
    }

    @Override
    public ConfigurationSection serialize(Inventory inventory) {
        var section = newSection();
        section.set("Material", inventory.getSize());
        return section;
    }
}
