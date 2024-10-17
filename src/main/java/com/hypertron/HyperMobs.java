package com.hypertron;

import com.hypertron.commands.HyperMobsCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class HyperMobs extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the command /hypermobs and set its executor to HyperMobsCommand
        getCommand("hypermobs").setExecutor(new HyperMobsCommand());

        // Log that the plugin has been enabled
        getLogger().info("HyperMobs has been enabled!");
    }

    @Override
    public void onDisable() {
        // Log that the plugin has been disabled
        getLogger().info("HyperMobs has been disabled!");
    }
}
