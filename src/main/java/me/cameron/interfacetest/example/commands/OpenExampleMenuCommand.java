package me.cameron.interfacetest.example.commands;

import me.cameron.interfacetest.InterfaceTest;
import me.cameron.interfacetest.example.menus.ExampleMenu;
import me.cameron.interfacetest.utils.Color;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenExampleMenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (Bukkit.getConsoleSender().equals(sender)) {
            sender.sendMessage(Color.format("&cYou cannot open this GUI"));
            return true;
        }

        new ExampleMenu("Example Menu", 5, (Player)sender, InterfaceTest.getPlugin(InterfaceTest.class));
        return true;
    }

}