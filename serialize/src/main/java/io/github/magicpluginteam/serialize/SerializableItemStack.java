package io.github.magicpluginteam.serialize;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

@YamlSymbol(symbol = "items")
public class SerializableItemStack implements YamlSectionSerializable<ItemStack> {
    @Override
    public ItemStack deserialize(ConfigurationSection conf) {
        return new ItemStack(Material.valueOf(conf.getString("Material")));
    }

    @Override
    public ConfigurationSection serialize(ItemStack itemStack) {
        var section = new YamlConfiguration();
        section.set("Material", itemStack.getType().name());
        return section;
    }
}
