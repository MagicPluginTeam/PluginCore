package io.github.magicpluginteam.lang;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;

import static io.github.magicpluginteam.lang.Const.LANG_KEY;

public class PlayerLang {

    public static String get(Player player) {
        return player.getMetadata(LANG_KEY).get(0).asString();
    }

    public static void set(Player player, String lang, Plugin plugin) {
        player.setMetadata(LANG_KEY, new FixedMetadataValue(plugin, lang));
    }

}
