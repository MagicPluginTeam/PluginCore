package io.github.magaicpluginteam.alert;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class ClickAlert extends EventAlertBase {

    ClickEvent.Action action;
    String content;

    public ClickAlert(String text, ClickEvent.Action action, String content) {
        super(text);
        this.action = action;
        this.content = content;
    }

    public ClickAlert(String text, String action, String content) {
        super(text);
        try {
            this.action = ClickEvent.Action.valueOf(action);
        } catch (Exception e) {
            throw new AssertionError(action + " is not valid");
        }
        this.content = content;
    }

    public String getAction() {
        return this.action.name();
    }


    @Override
    public void event(TextComponent component, Object...args) {
        component.setClickEvent(new ClickEvent(action, String.format(content, args)));
    }
}
