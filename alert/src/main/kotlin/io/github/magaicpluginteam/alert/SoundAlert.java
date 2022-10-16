package io.github.magaicpluginteam.alert;

import org.bukkit.entity.Player;

public class SoundAlert implements Alert {

    public SoundAlert(String sound) {
        this.sound = sound;
    }

    String sound;

    @Override
    public void send(Player player, Object... args) {
        player.playSound(player.getLocation(), sound, 1f, 1f);
    }
}
