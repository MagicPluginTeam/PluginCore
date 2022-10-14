package io.github.magicpluginteam.serialize;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

public class SerializeUtils {

    public <T> HashMap<String, T> deserialize(ConfigurationSection conf, YamlSerializable<T> yamlSerializable) {
        var map = new HashMap<String, T>();
        for (var keys : conf.getKeys(false)) {
            map.put(keys, yamlSerializable.deserialize(conf.getConfigurationSection(keys)));
        }
        return map;
    }

    public <T> ConfigurationSection serialize(HashMap<String, T> map, YamlSerializable<T> yamlSerializable) {
        var section = yamlSerializable.newSection();
        for (var entry : map.entrySet()) {
            section.set(entry.getKey(), yamlSerializable.serialize(entry.getValue()));
        }
        return section;
    }


}
