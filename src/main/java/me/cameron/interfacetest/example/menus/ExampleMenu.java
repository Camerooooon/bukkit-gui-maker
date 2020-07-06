package me.cameron.interfacetest.example.menus;

import me.cameron.interfacetest.InterfaceTest;
import me.cameron.interfacetest.utils.menu.Button;
import me.cameron.interfacetest.utils.menu.Menu;
import me.cameron.interfacetest.utils.menu.buttons.ArrayButton;
import me.cameron.interfacetest.utils.menu.buttons.PageButton;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ExampleMenu extends Menu {

    public ExampleMenu(String title, Integer rows, Player player, Plugin plugin) {
        super(title, rows, player, plugin);

        addButton(new Button(4, this, new ItemStack(Material.ARMOR_STAND)) {

            @Override
            public void onClick(ClickType type) {
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 0);
            }

            @Override
            public void onCreation() {
                setStatic(true);
                setTitle("&bStatic Button");
                addLore("&7&m-------------------------------");
                addLore("&bStatic buttons will remain on the");
                addLore("&bmenu even after a page is turned");
                addLore("&7&m-------------------------------");
            }

        });

        ArrayButton arrayButton = new ArrayButton(this, 9, 36) {
            @Override
            public void onClick(ClickType type) {

            }

            @Override
            public void onCreation() {

            }
        };

        arrayButton.addButton(new Button(0, this, new ItemStack(Material.REDSTONE_COMPARATOR)) {

            @Override
            public void onClick(ClickType type) {
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1, 0);
                new SettingsExampleMenu("My Settings", player, InterfaceTest.getPlugin(InterfaceTest.class));
            }

            @Override
            public void onCreation() {
                setTitle("&bSettings Example");
                addLore("&7&m-------------------------------");
                addLore("&bClick to view this example");
                addLore("&7&m-------------------------------");
            }

        });

        arrayButton.addButton(new Button(0, this, new ItemStack(Material.REDSTONE_COMPARATOR)) {

            @Override
            public void onClick(ClickType type) {
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1, 0);
                new AdministrativeProfileExampleMenu("Profile", player, InterfaceTest.getPlugin(InterfaceTest.class));
            }

            @Override
            public void onCreation() {
                setTitle("&bAdministrative Profile Example");
                addLore("&7&m-------------------------------");
                addLore("&bClick to view this example");
                addLore("&7&m-------------------------------");
            }

        });

        arrayButton.addButton(new Button(0, this, new ItemStack(Material.BOOKSHELF)) {

            @Override
            public void onClick(ClickType type) {
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1, 0);
                new ArrayButtonExampleMenu("Punishments", player, InterfaceTest.getPlugin(InterfaceTest.class));
            }

            @Override
            public void onCreation() {
                setTitle("&bPunishment History Example");
                addLore("&7&m-------------------------------");
                addLore("&bClick to view this example");
                addLore("&7&m-------------------------------");
            }

        });

        arrayButton.updateButtons();
        addButton(arrayButton);

        Button nextPage = null;
        Button previousPage = null;

        nextPage = new PageButton(getSlots() - 1, this, new ItemStack(Material.ARROW), true) {

            @Override
            public void onClick(ClickType type) {
                getMenu().setPage(getMenu().getPage() + 1);
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
            }

            @Override
            public void onCreation() {
                setStatic(true);
                setTitle("&aNext Page");
            }

        };

        previousPage = new PageButton(getSlots() - 9, this, new ItemStack(Material.ARROW), false) {

            @Override
            public void onClick(ClickType type) {
                getMenu().setPage(getMenu().getPage() - 1);
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
            }

            @Override
            public void onCreation() {
                setStatic(true);
                setTitle("&aPrevious Page");
            }

        };

        addButton(nextPage);
        addButton(previousPage);

    }

}
