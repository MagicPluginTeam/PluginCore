package io.github.magaicpluginteam.alert;

import io.github.magicpluginteam.serialize.YamlSectionSerializable;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "chat")
public class SerializableChatAlert implements YamlSectionSerializable<ChatAlert> {
    @Override
    public ChatAlert deserialize(ConfigurationSection conf) {
        return new ChatAlert(conf.getString("_"));
    }

    @Override
    public ConfigurationSection serialize(ChatAlert chatAlert) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("_", chatAlert.message);
        return section;
    }
}
