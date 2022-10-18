package io.github.magaicpluginteam.alert;

import io.github.magicpluginteam.serialize.YamlSectionSerializable;
import io.github.magicpluginteam.serialize.symbol.YamlSymbol;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

@YamlSymbol(symbol = "actionbar")
public class ActionBarMessageSerialize implements YamlSectionSerializable<ActionBarMessage> {
    @Override
    public ActionBarMessage deserialize(ConfigurationSection conf) {
        return new ActionBarMessage(conf.getString("_"));
    }

    @Override
    public ConfigurationSection serialize(ActionBarMessage actionBarMessage) {
        YamlConfiguration section = new YamlConfiguration();
        section.set("_", actionBarMessage.message);
        return section;
    }
}
