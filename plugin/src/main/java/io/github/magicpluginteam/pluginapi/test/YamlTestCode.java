package io.github.magicpluginteam.pluginapi.test;

import io.github.magicpluginteam.pluginapi.Plugin;
import io.github.magicpluginteam.pluginapi.yaml.Yaml;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;

public class YamlTestCode extends TestCodeBase {
    public YamlTestCode(Plugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onJoin(PlayerChatEvent event) {
        Player player = event.getPlayer();
        long before = System.currentTimeMillis();
        Yaml yaml = new Yaml(plugin.getDataFolder());
        long after = System.currentTimeMillis();
        yaml
                .messages
                .get("KR")
                .get("test")
                .send(player, "Bruce");
    }
}
