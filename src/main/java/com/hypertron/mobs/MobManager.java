package com.hypertron.mobs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MobManager {

    // List all mobs with a GUI
    public static void openMobListGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Mob List");

        for (String mobName : getAllMobNames()) {
            ItemStack mobHead = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = mobHead.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + mobName);
            mobHead.setItemMeta(meta);
            inventory.addItem(mobHead);
        }

        player.openInventory(inventory);
    }

    // Remove mob GUI
    public static void openRemoveMobGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.RED + "Remove Mob");

        for (String mobName : getAllMobNames()) {
            ItemStack mobHead = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = mobHead.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + mobName);
            mobHead.setItemMeta(meta);
            inventory.addItem(mobHead);
        }

        player.openInventory(inventory);
    }

    // Edit mob GUI
    public static void openEditMobGUI(Player player, String mobName) {
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.BLUE + "Edit " + mobName);

        // Adding toggle for active/passive
        ItemStack toggleActivePassive = new ItemStack(Material.LEVER);
        ItemMeta meta = toggleActivePassive.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Toggle Active/Passive");
        toggleActivePassive.setItemMeta(meta);
        inventory.addItem(toggleActivePassive);

        // Adding health editing option
        ItemStack editHealth = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta healthMeta = editHealth.getItemMeta();
        healthMeta.setDisplayName(ChatColor.YELLOW + "Edit Health");
        editHealth.setItemMeta(healthMeta);
        inventory.addItem(editHealth);

        player.openInventory(inventory);
    }

    public static void removeMob(Player player, String mobName) {
        // Logic to remove the mob from the world and custom mob list
        player.sendMessage(ChatColor.GREEN + "Mob " + mobName + " removed.");
    }

    public static void freezeMob(Player player, String mobName) {
        // Logic to freeze/unfreeze the mob
        player.sendMessage(ChatColor.GREEN + "Mob " + mobName + " has been frozen.");
    }

    public static void despawnAllMobs() {
        // Logic to despawn all custom mobs
    }

    public static void spawnMob(Player player, String mobType, String mobName, double health, double speed, int attack, int defense, String state, String targetType) {
        EntityType entityType;

        try {
            entityType = EntityType.valueOf(mobType);
        } catch (IllegalArgumentException e) {
            player.sendMessage(ChatColor.RED + "Invalid mob type: " + mobType);
            return;
        }

        // Spawn the mob
        Mob mob = (Mob) player.getWorld().spawnEntity(player.getLocation(), entityType);
        mob.setCustomName(ChatColor.GREEN + mobName);
        mob.setHealth(health);
        // Here you can set speed, attack, defense, and behavior based on state and targetType

        // Example behavior setting (this is where you implement your custom behavior)
        if (state.equalsIgnoreCase("active")) {
            // Set the mob to target players or specific entities
            // Logic to make the mob active towards players
        } else {
            // Logic for passive behavior
        }

        player.sendMessage(ChatColor.GREEN + mobName + " has been spawned with health: " + health + ", speed: " + speed + ", attack: " + attack + ", defense: " + defense + ", state: " + state + ", target type: " + targetType);
    }

    public static String[] getAllMobNames() {
        // This should return a list of all custom mob names.
        return new String[]{"MyZombie", "MyCreeper", "MyBlaze"};
    }
}
