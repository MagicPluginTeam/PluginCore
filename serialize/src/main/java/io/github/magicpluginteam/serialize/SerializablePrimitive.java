package io.github.magicpluginteam.serialize;

import io.github.magicpluginteam.serialize.utils.NumberUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class SerializablePrimitive implements YamlSectionSerializable<Object> {
    @Override
    public Object deserialize(ConfigurationSection conf) {
        var name = "_";
        if (conf.isString(name)) return conf.getString(name);
        else if (conf.isBoolean(name)) return conf.getBoolean(name);
        else if (conf.isList(name)) return conf.getStringList(name);
        else return NumberUtils.integerIf(conf.getDouble(name));
    }

    @Override
    public ConfigurationSection serialize(Object o) {
        var section = new YamlConfiguration();
        section.set("_", o);
        return section;
    }
}
