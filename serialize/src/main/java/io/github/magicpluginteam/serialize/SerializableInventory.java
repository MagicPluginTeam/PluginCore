package io.github.magicpluginteam.serialize;

import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;

@YamlSymbol(symbol = "inventories")
public class SerializableInventory implements YamlSectionSerializable<Inventory> {
    @Override
    public Inventory deserialize(ConfigurationSection conf) {
        return Bukkit.createInventory(null, conf.getInt("InventorySize"));
    }

    @Override
    public ConfigurationSection serialize(Inventory inventory) {
        var section = new YamlConfiguration();
        section.set("Material", inventory.getSize());
        return section;
    }
}
