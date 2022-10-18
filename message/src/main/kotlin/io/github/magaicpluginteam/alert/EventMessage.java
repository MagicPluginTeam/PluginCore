package io.github.magaicpluginteam.alert;

import net.md_5.bungee.api.chat.TextComponent;

public interface EventMessage extends Message {

    void event(TextComponent component, Object...args);

}
