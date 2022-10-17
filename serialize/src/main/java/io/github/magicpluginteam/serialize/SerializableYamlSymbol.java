package io.github.magicpluginteam.serialize;

import io.github.magicpluginteam.serialize.utils.ClassUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Arrays;
import java.util.HashMap;

public class SerializableYamlSymbol<T> implements YamlSectionSerializable<T> {

    private final HashMap<String, YamlSectionSerializable<T>> serializableMap = new HashMap<>();

    public SerializableYamlSymbol(Class<? extends YamlSectionSerializable<? extends T>>[] classes) {
        Arrays.stream(classes).forEach(this::bind);
    }

    public void bind(Class<? extends YamlSectionSerializable<? extends T>> clazz) {
        YamlSerializable annotation = clazz.getAnnotation(YamlSerializable.class);
        if (annotation == null) {
            throw new AssertionError(clazz.getSimpleName() + " does not have YamlSerializable annotation");
        }
        try {
            String symbol = annotation.symbol();
            if (serializableMap.getOrDefault(symbol, null) != null) {
                throw new AssertionError(symbol + " symbol is already exists");
            }
            serializableMap.put(symbol, (YamlSectionSerializable<T>) clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T deserialize(ConfigurationSection conf) {
        String symbol = conf.getKeys(false).stream().findFirst().orElse(null);
        if (symbol == null)
            throw new AssertionError("symbol is not exists");
        var serializable = serializableMap.getOrDefault(symbol, null);
        if (serializable == null)
            throw new AssertionError(symbol + " symbol is not valid");
        return serializable.deserialize(conf.getConfigurationSection(symbol));
    }

    @Override
    public ConfigurationSection serialize(T t) {
        Class<?> type = t.getClass();
        for (var entry : serializableMap.entrySet()) {
            Class<?> genericType = ClassUtils.getGenericType(entry.getValue().getClass());
            if (genericType.equals(type)) {
                YamlConfiguration section = new YamlConfiguration();
                section.set(entry.getKey(), entry.getValue().serialize(t));
                return section;
            }
        }
        throw new AssertionError(type.getSimpleName() + " does not match any serializer");
    }
}
