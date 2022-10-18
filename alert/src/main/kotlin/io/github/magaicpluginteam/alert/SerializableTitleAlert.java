package io.github.magaicpluginteam.alert;

import io.github.magicpluginteam.serialize.YamlSectionSerializable;
import io.github.magicpluginteam.serialize.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "title")
public class SerializableTitleAlert implements YamlSectionSerializable<TitleAlert> {
    @Override
    public TitleAlert deserialize(ConfigurationSection conf) {
        return new TitleAlert(
                conf.getInt("fadeIn"),
                conf.getInt("stay"),
                conf.getInt("fadeOut"),
                conf.getString("title"),
                conf.getString("subtitle")
        );
    }

    @Override
    public ConfigurationSection serialize(TitleAlert titleAlert) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("fadeIn", titleAlert.fadeIn);
        section.set("stay", titleAlert.stay);
        section.set("fadeOut", titleAlert.fadeOut);
        section.set("title", titleAlert.title);
        section.set("subtitle", titleAlert.subtitle);
        return section;
    }
}
