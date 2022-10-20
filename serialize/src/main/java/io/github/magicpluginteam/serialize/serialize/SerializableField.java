package io.github.magicpluginteam.serialize.serialize;

import io.github.magicpluginteam.serialize.YamlSectionSerializable;
import io.github.magicpluginteam.serialize.utils.ClassUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.lang.reflect.Field;

public class SerializableField<T> implements YamlSectionSerializable<T> {

    private final T t;

    public SerializableField(T t) {
        this.t = t;
    }

    @Override
    public T deserialize(ConfigurationSection conf) {
        Class<?> clazz = ClassUtils.getGenericType(SerializableField.class);
        for (Field field : clazz.getDeclaredFields()) {
            YamlField annotation = field.getAnnotation(YamlField.class);
            String name = annotation.key();
            try {
                if (!conf.isSet(name)) {
                    throw new AssertionError(clazz.getSimpleName() + " " + name + " does not exists in the section");
                }
                field.setAccessible(true);
                field.set(t, conf.get(name));
            } catch (IllegalAccessException e) {
                throw new AssertionError("an error occurred while setting " + clazz.getSimpleName() + " " + name + " field ");
            }
        }
        return t;
    }

    @Override
    public ConfigurationSection serialize(T o) {
        YamlConfiguration section = new YamlConfiguration();
        Class<?> clazz = ClassUtils.getGenericType(SerializableField.class);
        for (Field field : clazz.getDeclaredFields()) {
            YamlField annotation = field.getAnnotation(YamlField.class);
            String name = annotation.key();
            field.setAccessible(true);
            try {
                Object value = field.get(t);
                section.set(name, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return section;
    }
}
