package io.github.magicpluginteam.serialize;

import org.bukkit.configuration.ConfigurationSection;

public interface YamlSectionSerializable<T> {

    T deserialize(ConfigurationSection conf);

    ConfigurationSection serialize(T t);

}

