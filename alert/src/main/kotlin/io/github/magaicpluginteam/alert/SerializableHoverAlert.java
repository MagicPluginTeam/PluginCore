package io.github.magaicpluginteam.alert;

import io.github.magicpluginteam.serialize.YamlSectionSerializable;
import io.github.magicpluginteam.serialize.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "hover")
public class SerializableHoverAlert implements YamlSectionSerializable<HoverAlert> {
    @Override
    public HoverAlert deserialize(ConfigurationSection conf) {
        return new HoverAlert(
                conf.getString("text"),
                conf.getString("action"),
                conf.getString("content")
        );
    }

    @Override
    public ConfigurationSection serialize(HoverAlert hoverAlert) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("text", hoverAlert.text);
        section.set("action", hoverAlert.action);
        section.set("content", hoverAlert.content);
        return section;
    }
}
