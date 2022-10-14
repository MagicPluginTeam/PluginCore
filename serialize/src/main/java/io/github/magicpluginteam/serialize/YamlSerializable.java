package io.github.magicpluginteam.serialize;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public interface YamlSerializable<T> {

    T deserialize(ConfigurationSection conf);

    ConfigurationSection serialize(T t);

}

