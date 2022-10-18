package io.github.magaicpluginteam.alert;

import io.github.magicpluginteam.serialize.YamlSectionSerializable;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "sound")
public class SerializableSoundAlert implements YamlSectionSerializable<SoundAlert> {
    @Override
    public SoundAlert deserialize(ConfigurationSection conf) {
        return new SoundAlert(conf.getString("_"));
    }

    @Override
    public ConfigurationSection serialize(SoundAlert chatAlert) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("_", chatAlert.sound);
        return section;
    }
}
