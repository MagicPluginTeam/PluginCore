package io.github.magicpluginteam.pluginapi;

import io.github.magicpluginteam.pluginapi.utils.ClassUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;

public class Plugin extends JavaPlugin implements Listener {

    private boolean allowTask = false;
    private ArrayList<Runnable> disableEvent = new ArrayList<>();

    public void addDisableEvent(Runnable runnable) {
        disableEvent.add(runnable);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getScheduler().cancelTasks(this);
        HandlerList.unregisterAll((org.bukkit.plugin.Plugin) this);
        ClassUtils.loadJarFilesToFolder(this, false, Arrays.asList(".yml", ".schem"));
        Bukkit.getPluginManager().registerEvents(this, this);
        allowTask = true;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        allowTask = false;
        disableEvent.forEach(Runnable::run);
    }
}
