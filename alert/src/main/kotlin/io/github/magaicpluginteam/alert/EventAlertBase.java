package io.github.magaicpluginteam.alert;

import io.github.magaicpluginteam.alert.utils.ArrayUtils;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class EventAlertBase implements EventAlert {

    String text;

    public EventAlertBase(String text) {
        this.text = text;
    }

    @Override
    public void send(Player player, Object... args) {
        TextComponent component = new TextComponent(String.format(text, args));
        Object[] reversed = ArrayUtils.reverse(args);
        event(component, reversed);
        player.spigot().sendMessage(component);
    }

    @Override
    public void event(TextComponent component, Object... args) {

    }
}
