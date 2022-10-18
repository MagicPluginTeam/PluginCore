package io.github.magaicpluginteam.alert.serialize;

import io.github.magaicpluginteam.alert.SoundMessage;
import io.github.magicpluginteam.serialize.YamlSectionSerializable;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "sound")
public class SoundMessageSerialize implements YamlSectionSerializable<SoundMessage> {
    @Override
    public SoundMessage deserialize(ConfigurationSection conf) {
        return new SoundMessage(conf.getString("_"));
    }

    @Override
    public ConfigurationSection serialize(SoundMessage chatAlert) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("_", chatAlert.sound);
        return section;
    }
}
