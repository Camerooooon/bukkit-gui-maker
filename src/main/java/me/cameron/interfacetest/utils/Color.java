package me.cameron.interfacetest.utils;

import org.bukkit.ChatColor;

public class Color {
    public static String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
