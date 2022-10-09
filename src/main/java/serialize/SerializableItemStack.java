package serialize;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

public class SerializableItemStack implements Serializable<ItemStack> {
    @Override
    public ItemStack deserialize(ConfigurationSection conf) {
        return new ItemStack(Material.valueOf(conf.getString("Material")));
    }

    @Override
    public ConfigurationSection serialize(ItemStack itemStack) {
        var section = newSection();
        section.set("Material", itemStack.getType().name());
        return section;
    }
}
