package com.hypertron.mobs;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CustomMob {
    private final String name;
    private final double health;
    private final double speed;
    private final double attack;
    private final double defense;

    public CustomMob(String name, double health, double speed, double attack, double defense) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
    }

    public void spawn(Player player) {
        Location location = player.getLocation();
        LivingEntity mob = (LivingEntity) player.getWorld().spawnEntity(location, EntityType.ZOMBIE); // Change to your desired mob type
        mob.setCustomName(name);
        mob.setHealth(health);
        
        // Set attributes
        // Implement your own logic to modify speed, attack, and defense as needed.
        
        player.sendMessage("Spawned custom mob: " + name);
    }
}
