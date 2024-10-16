package com.hypertron;

import org.bukkit.plugin.java.JavaPlugin;
import com.hypertron.commands.CreateMobCommand;

public class HyperMobs extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("hypermob").setExecutor(new CreateMobCommand());
        getLogger().info("HyperMobs has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("HyperMobs has been disabled!");
    }
}
