package org.cjohnson.sensorplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.cjohnson.sensorplugin.command.SensorCommand;
import org.cjohnson.sensorplugin.command.SlimeCommand;
import org.cjohnson.sensorplugin.sensor.slime.SlimeIndicator;

public final class SensorPlugin extends JavaPlugin {
    private SlimeIndicator indicator;
    private BukkitTask task;

    @Override
    public void onEnable() {
        indicator = new SlimeIndicator();
        getCommand("sensor").setExecutor(new SensorCommand());
        getCommand("slime").setExecutor(new SlimeCommand(indicator));

        task = getServer().getScheduler().runTaskTimer(this, indicator::indicate, 0L, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
