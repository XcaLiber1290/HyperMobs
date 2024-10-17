package com.hypertron.listeners;

import com.hypertron.mobs.MobManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;


public class MobGUIClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem == null || !clickedItem.hasItemMeta()) return;

        String inventoryName = event.getView().getTitle();

        if (inventoryName.contains("Mob List")) {
            event.setCancelled(true);
            // Logic for handling mob list clicks
        }

        if (inventoryName.contains("Remove Mob")) {
            event.setCancelled(true);
            String mobName = ChatColor.stripColor(clickedItem.getItemMeta().getDisplayName());
            MobManager.removeMob(player, mobName);
            player.closeInventory();
        }

        if (inventoryName.contains("Edit")) {
            event.setCancelled(true);
            String mobName = inventoryName.split(" ")[1]; // Get the mob name from the title

            // Toggle active/passive
            if (clickedItem.getType() == Material.LEVER) {
                // Logic to toggle mob active/passive
                player.sendMessage(ChatColor.GREEN + "Toggled active/passive for " + mobName);
            }

            // Edit health
            if (clickedItem.getType() == Material.GOLDEN_APPLE) {
                // Open sign input for health stat
                player.sendMessage(ChatColor.YELLOW + "Enter new health value for " + mobName);
                // Use a sign interface or similar mechanic here
            }
        }
    }
}
