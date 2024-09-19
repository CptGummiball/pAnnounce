package org.cptgummiball.pAnnounce;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        this.config = getConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getLogger().info("pAnnounce enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("pAnnounce disabled.");
    }

    public FileConfiguration getPluginConfig() {
        return this.config;
    }
}