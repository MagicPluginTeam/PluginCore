package io.github.magaicpluginteam.alert;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class HoverAlert extends EventAlertBase {

    HoverEvent.Action action;
    String content;

    public HoverAlert(String text, HoverEvent.Action action, String content) {
        super(text);
        this.action = action;
        this.content = content;
    }

    public HoverAlert(String text, String action, String content) {
        super(text);
        try {
            this.action = HoverEvent.Action.valueOf(action);
        } catch (Exception e) {
            throw new AssertionError(action + " is not valid");
        }
        this.content = content;
    }

    @Override
    public void event(TextComponent component, Object...args) {

        component.setHoverEvent(new HoverEvent(action, new ComponentBuilder(String.format(content, args)).create()));
    }
}
