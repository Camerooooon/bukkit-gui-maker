package me.cameron.interfacetest;

import me.cameron.interfacetest.example.commands.OpenExampleMenuCommand;
import me.cameron.interfacetest.utils.menu.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class InterfaceTest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("testmenu").setExecutor(new OpenExampleMenuCommand());
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
