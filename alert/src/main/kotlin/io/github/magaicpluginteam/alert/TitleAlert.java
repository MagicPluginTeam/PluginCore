package io.github.magaicpluginteam.alert;

import io.github.magaicpluginteam.alert.utils.ArrayUtils;
import org.bukkit.entity.Player;

public class TitleAlert implements Alert {

    int fadeIn;
    int stay;
    int fadeOut;
    String title;
    String subtitle;

    public TitleAlert(int fadeIn, int stay, int fadeOut, String title, String subtitle) {
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public void send(Player player, Object... args) {
        Object[] reversed = ArrayUtils.reverse(args);
        player.sendTitle(String.format(title, args), String.format(subtitle, reversed), fadeIn, stay, fadeOut);
    }
}
