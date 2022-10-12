package io.github.magicpluginteam.serialize;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

public class SerializeUtils {

    public <T> HashMap<String, T> deserialize(ConfigurationSection conf, Serializable<T> serializable) {
        var map = new HashMap<String, T>();
        for (var keys : conf.getKeys(false)) {
            map.put(keys, serializable.deserialize(conf.getConfigurationSection(keys)));
        }
        return map;
    }

    public <T> ConfigurationSection serialize(HashMap<String, T> map, Serializable<T> serializable) {
        var section = serializable.newSection();
        for (var entry : map.entrySet()) {
            section.set(entry.getKey(), serializable.serialize(entry.getValue()));
        }
        return section;
    }


}
