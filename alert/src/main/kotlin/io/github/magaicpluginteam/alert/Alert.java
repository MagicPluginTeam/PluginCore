package io.github.magaicpluginteam.alert;

import org.bukkit.entity.Player;

public interface Alert {
    
    void send(Player player, Object...args);
    
}
