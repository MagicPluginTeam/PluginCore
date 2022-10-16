package io.github.magaicpluginteam.alert;

import org.bukkit.entity.Player;

public class ChatAlert implements Alert {

    String message;

    public ChatAlert(String message) {
        this.message = message;
    }

    @Override
    public void send(Player player, Object...args) {
        player.sendMessage(String.format(message, args));
    }

}
