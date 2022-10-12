package io.github.magicpluginteam.serialize;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public interface Serializable<T> {

    T deserialize(ConfigurationSection conf);

    ConfigurationSection serialize(T t);

    default ConfigurationSection newSection() {
        return new YamlConfiguration();
    }

}

