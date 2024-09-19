package org.cptgummiball.pAnnounce;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {

    private final Plugin plugin;

    public PlayerJoinListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player joiningPlayer = event.getPlayer();
        FileConfiguration config = plugin.getConfig();

        // Check if the joining player is listed in the config
        if (config.contains(joiningPlayer.getName())) {
            String type = config.getString(joiningPlayer.getName() + ".Type");
            String text = config.getString(joiningPlayer.getName() + ".Text");
            String subtext = config.getString(joiningPlayer.getName() + ".Subtext");
            String textColor = config.getString(joiningPlayer.getName() + ".Textcolor");
            String subtextColor = config.getString(joiningPlayer.getName() + ".Subtextcolor");
            String soundName = config.getString(joiningPlayer.getName() + ".Sound");

            // Handling colorization of text if applicable
            ChatColor mainTextColor = textColor != null ? ChatColor.valueOf(textColor.toUpperCase()) : ChatColor.WHITE;
            ChatColor subTextColor = subtextColor != null ? ChatColor.valueOf(subtextColor.toUpperCase()) : ChatColor.WHITE;

            // Handle Sound
            Sound sound = null;
            try {
                sound = Sound.valueOf(soundName.toUpperCase());
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning("Invalid sound: " + soundName + " for player " + joiningPlayer.getName());
            }

            // Send announcement to all players online
            for (Player player : Bukkit.getOnlinePlayers()) {
                // Actionbar
                if (type.equalsIgnoreCase("Actionbar")) {
                    TextComponent actionBarMessage = new TextComponent(mainTextColor + text);
                    player.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR, actionBarMessage);
                }
                // Chat
                else if (type.equalsIgnoreCase("Chat")) {
                    player.sendMessage(mainTextColor + text);
                }
                // Title
                else if (type.equalsIgnoreCase("Title")) {
                    player.sendTitle(mainTextColor + text, subTextColor + subtext, 10, 70, 20);
                }

                // Play sound for all players
                if (sound != null) {
                    player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
                }
            }
        }
    }
}
