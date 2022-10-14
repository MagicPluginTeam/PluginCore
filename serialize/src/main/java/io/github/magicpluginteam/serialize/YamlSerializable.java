package io.github.magicpluginteam.serialize;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;

public class YamlSerializable<T> {

    YamlSectionSerializable<T> sectionSerializable;
    HashMap<String, T> map = new HashMap<>();

    public YamlSerializable(YamlSectionSerializable<T> yamlSerializable) {
        this.sectionSerializable = yamlSerializable;
    }

    public void deserialize(ConfigurationSection conf) {
        for (var keys : conf.getKeys(false)) {
            map.put(keys, sectionSerializable.deserialize(conf.getConfigurationSection(keys)));
        }
    }

    public ConfigurationSection serialize() {
        var section = new YamlConfiguration();
        for (var entry : map.entrySet()) {
            section.set(entry.getKey(), sectionSerializable.serialize(entry.getValue()));
        }
        return section;
    }


}
