package io.github.magicpluginteam.lang;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

import static io.github.magicpluginteam.lang.Const.LANG_KEY;

public class PlayerLangSupport implements Listener {

    private final Plugin plugin;
    private final String defLang;

    public PlayerLangSupport(Plugin plugin, String defLang) {
        this.plugin = plugin;
        this.defLang = defLang;
    }



    @SuppressWarnings("unused")
    @EventHandler(priority = EventPriority.LOWEST)
    private void onJoin(PlayerJoinEvent event) {
        Metadatable player = event.getPlayer();
        if (player.hasMetadata(LANG_KEY)) {
            player.setMetadata(LANG_KEY, new FixedMetadataValue(plugin, defLang));
        }
    }

    @SuppressWarnings("unused")
    @EventHandler(priority = EventPriority.MONITOR)
    private void onQuit(PlayerQuitEvent event) {
        Metadatable player = event.getPlayer();
        if (player.hasMetadata(LANG_KEY)) {
            player.removeMetadata(LANG_KEY, plugin);
        }
    }

}
