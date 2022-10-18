package io.github.magaicpluginteam.alert;

import org.bukkit.entity.Player;

public interface Message {
    
    void send(Player player, Object...args);
    
}
