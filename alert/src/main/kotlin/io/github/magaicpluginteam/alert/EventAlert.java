package io.github.magaicpluginteam.alert;

import net.md_5.bungee.api.chat.TextComponent;

public interface EventAlert extends Alert {

    void event(TextComponent component, Object...args);

}
