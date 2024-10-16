package com.hypertron.commands;

import com.hypertron.mobs.CustomMob;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateMobCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        if (args.length < 6 || !args[0].equalsIgnoreCase("spawn")) {
            sender.sendMessage("Usage: /hypermob spawn <name> <health> <speed> <attack> <defense>");
            return true;
        }

        String name = args[1];
        double health, speed, attack, defense;

        // Error handling for numeric values
        try {
            health = Double.parseDouble(args[2]);
            speed = Double.parseDouble(args[3]);
            attack = Double.parseDouble(args[4]);
            defense = Double.parseDouble(args[5]);
        } catch (NumberFormatException e) {
            sender.sendMessage("Please enter valid numbers for health, speed, attack, and defense.");
            return true;
        }

        CustomMob customMob = new CustomMob(name, health, speed, attack, defense);
        customMob.spawn((Player) sender);

        sender.sendMessage("Custom mob " + name + " created!");
        return true;
    }
}
