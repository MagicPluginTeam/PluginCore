package io.github.magaicpluginteam.alert;

import io.github.magicpluginteam.serialize.YamlSectionSerializable;
import io.github.magicpluginteam.serialize.YamlSerializable;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSerializable(symbol = "actionbar")
public class SerializableActionBarAlert implements YamlSectionSerializable<ActionBarAlert> {
    @Override
    public ActionBarAlert deserialize(ConfigurationSection conf) {
        return new ActionBarAlert(conf.getString("_"));
    }

    @Override
    public ConfigurationSection serialize(ActionBarAlert actionBarAlert) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("_", actionBarAlert.message);
        return section;
    }
}
