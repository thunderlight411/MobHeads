package com.cyber.mobheads.Utilities;


import com.cyber.mobheads.Config.ConfigController;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Broadcaster {
    public static void broadCastMobHead(Player player, String displayName) {
        String configMessage = ConfigController.getMessage("Messages.Success.Broadcast-message-mob");

        if (!configMessage.isEmpty()) {
            Bukkit.broadcastMessage(configMessage
                    .replace("[playername]", player.getName())
                    .replace("[mobname]", displayName));
        }
    }

    public static void broadCastPlayerHead(Player killer, Player victim) {
        if (!ConfigController.broadcastEnabledPlayers()) {
            return;
        }

        String configMessage = ConfigController.getMessage("Messages.Success.Broadcast-message-player");

        if (!configMessage.isEmpty()) {
            /* 40 */
            Bukkit.broadcastMessage(configMessage
                    .replace("[killer]", killer.getName())
                    .replace("[victim]", victim.getName()));

        }

    }


    public static void outputInfoConsole(String message, int urgency) {
        ChatColor green = ChatColor.GREEN;
        ChatColor yellow = ChatColor.YELLOW;
        ChatColor red = ChatColor.RED;

        if (urgency <= 0) {
            Bukkit.getServer().getConsoleSender().sendMessage(green + "[Mob Heads] " + message);
        } else if (urgency == 1 && !ConfigController.surpressWarnings()) {
            Bukkit.getServer().getConsoleSender().sendMessage(yellow + "[Mob Heads] " + message);
        } else if (urgency >= 2 && !ConfigController.surpressErrors()) {
            Bukkit.getServer().getConsoleSender().sendMessage(red + "[Mob Heads] " + message);
        }
    }
}


