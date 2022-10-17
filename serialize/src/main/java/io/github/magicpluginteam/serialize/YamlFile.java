package io.github.magicpluginteam.serialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface YamlFile {
    String name();

    /**
     * If array elements are more than one, bind as SerializableYamlSymbol
     */
    Class<? extends YamlSectionSerializable<?>>[] serializable();

}
