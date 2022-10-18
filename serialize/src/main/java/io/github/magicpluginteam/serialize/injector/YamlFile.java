package io.github.magicpluginteam.serialize.injector;

import io.github.magicpluginteam.serialize.YamlSectionSerializable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface YamlFile {
    String name();

    Class<? extends YamlSectionSerializable<?>>[] serializable();

}
