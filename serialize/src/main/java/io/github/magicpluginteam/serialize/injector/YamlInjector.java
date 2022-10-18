package io.github.magicpluginteam.serialize.injector;

import io.github.magicpluginteam.serialize.YamlSection;
import io.github.magicpluginteam.serialize.symbol.SerializableYamlSymbol;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.lang.reflect.Field;

public class YamlInjector {

    public static void inject(Object obj, File root) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            YamlFile annotation = field.getAnnotation(YamlFile.class);
            if (annotation == null) {
                continue;
            }
            var serializableClasses  = annotation.serializable();
            try {
                YamlSection<?> section;
                if (serializableClasses.length == 1) {
                    section = new YamlSection<>(serializableClasses[0].newInstance());
                    field.set(obj, section);
                } else {
                    section = new YamlSection<>(new SerializableYamlSymbol<>(serializableClasses));
                    field.set(obj, section);
                }
                String name = annotation.name();
                section.deserialize(YamlConfiguration.loadConfiguration(new File(root, name)));
            } catch (IllegalAccessException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
