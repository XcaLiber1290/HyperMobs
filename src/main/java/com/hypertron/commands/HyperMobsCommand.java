package com.hypertron.commands;

import com.hypertron.mobs.MobManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HyperMobsCommand extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /hypermobs <list|remove|edit|despawnall|freeze|spawn>");
            return true;
        }

        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "list":
                MobManager.openMobListGUI(player);
                break;

            case "remove":
                if (args.length == 2) {
                    MobManager.removeMob(player, args[1]);
                } else {
                    MobManager.openRemoveMobGUI(player);
                }
                break;

            case "edit":
                if (args.length == 2) {
                    MobManager.openEditMobGUI(player, args[1]);
                } else {
                    player.sendMessage(ChatColor.RED + "Usage: /hypermobs edit <mob_name>");
                }
                break;

            case "despawnall":
                MobManager.despawnAllMobs();
                player.sendMessage(ChatColor.GREEN + "All custom mobs have been despawned.");
                break;

            case "freeze":
                if (args.length == 2) {
                    MobManager.freezeMob(player, args[1]);
                } else {
                    player.sendMessage(ChatColor.RED + "Usage: /hypermobs freeze <mob_name>");
                }
                break;

            case "spawn":
                if (args.length == 8) {
                    String mobType = args[1].toUpperCase();
                    String mobName = args[2];
                    double health = Double.parseDouble(args[3]);
                    double speed = Double.parseDouble(args[4]);
                    int attack = Integer.parseInt(args[5]);
                    int defense = Integer.parseInt(args[6]);
                    String state = args[7].toLowerCase();
                    String targetType = args[8].toLowerCase();
                    
                    MobManager.spawnMob(player, mobType, mobName, health, speed, attack, defense, state, targetType);
                    player.sendMessage(ChatColor.GREEN + "Spawned " + mobName + "!");
                } else {
                    player.sendMessage(ChatColor.RED + "Usage: /hypermobs spawn <mob_type> <mob_name> <health> <speed> <attack> <defense> <active/passive> <target_players/npc>");
                }
                break;

            default:
                player.sendMessage(ChatColor.RED + "Unknown subcommand.");
        }
        return true;
    }
}
