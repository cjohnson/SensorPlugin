package org.cjohnson.sensorplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.cjohnson.sensorplugin.command.SensorCommand;

public final class SensorPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("sensor").setExecutor(new SensorCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
