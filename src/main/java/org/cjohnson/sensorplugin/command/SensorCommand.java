package org.cjohnson.sensorplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SensorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!command.getName().equalsIgnoreCase("sensor")) return false;

        sender.sendMessage("SlimeSensor version 1.0-SNAPSHOT");

        return false;
    }
}
