package io.github.magicpluginteam.serialize;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class YamlSection<T> {

    private final YamlSectionSerializable<T> sectionSerializable;
    private final HashMap<String, T> map = new HashMap<>();

    public YamlSection(YamlSectionSerializable<T> sectionSerializable) {
        this.sectionSerializable = sectionSerializable;
    }

    public T get(String name) {
        return map.getOrDefault(name, null);
    }

    public void deserialize(ConfigurationSection conf) {
        for (var key : conf.getKeys(false)) {
            ConfigurationSection section;
            if (conf.isConfigurationSection(key)) {
                section = conf.getConfigurationSection(key);
            } else {
                section = new YamlConfiguration();
                section.set("_", conf.get(key));
            }
            map.put(key, sectionSerializable.deserialize(section));
        }
    }

    public YamlConfiguration serialize() {
        var section = new YamlConfiguration();
        for (var entry : map.entrySet()) {
            var sect = sectionSerializable.serialize(entry.getValue());
            if (sect.isSet("_"))
                section.set(entry.getKey(), sect.get("_"));
            else section.set(entry.getKey(), sect);
        }
        return section;
    }


}
