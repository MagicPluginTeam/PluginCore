package serialize;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
