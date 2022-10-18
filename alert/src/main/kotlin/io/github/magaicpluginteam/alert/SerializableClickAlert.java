package io.github.magaicpluginteam.alert;

import io.github.magicpluginteam.serialize.YamlSectionSerializable;
import io.github.magicpluginteam.serialize.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "click")
public class SerializableClickAlert implements YamlSectionSerializable<ClickAlert> {
    @Override
    public ClickAlert deserialize(ConfigurationSection conf) {
        return new ClickAlert(
                conf.getString("text"),
                conf.getString("action"),
                conf.getString("content")
        );
    }

    @Override
    public ConfigurationSection serialize(ClickAlert clickAlert) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("text", clickAlert.text);
        section.set("action", clickAlert.action);
        section.set("content", clickAlert.content);
        return section;
    }
}
