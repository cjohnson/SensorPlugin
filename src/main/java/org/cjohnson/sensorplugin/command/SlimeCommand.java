package org.cjohnson.sensorplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cjohnson.sensorplugin.sensor.slime.SlimeIndicator;
import org.cjohnson.sensorplugin.sensor.slime.SlimeMessages;

public class SlimeCommand implements CommandExecutor {
    private SlimeIndicator indicator;

    public SlimeCommand(SlimeIndicator indicator) {
        this.indicator = indicator;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!command.getName().equalsIgnoreCase("slime")) return false;

        if (!(sender instanceof Player player)) {
            SlimeMessages.sendNonPlayerMessage(sender);
            return false;
        }

        indicator.toggle(player);

        return true;
    }
}