package me.cameron.interfacetest.example.menus;

import me.cameron.interfacetest.utils.Color;
import me.cameron.interfacetest.utils.menu.Button;
import me.cameron.interfacetest.utils.menu.Menu;
import me.cameron.interfacetest.utils.menu.buttons.SwitcherButton;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

public class SettingsExampleMenu extends Menu {

    public SettingsExampleMenu(String title, Player player, Plugin plugin) {
        super(title, 3, player, plugin);

        addButton(new Button(4, this, new ItemStack(Material.SKULL_ITEM)) {

            @Override
            public void onClick(ClickType type) {
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 0);
            }

            @Override
            public void onCreation() {
                SkullMeta meta = (SkullMeta)getMeta();
                meta.setOwner(player.getName());
                getItem().setDurability((short)3);
                getItem().setItemMeta(meta);

                setTitle("&6Your Settings");
                addLore("&7&m-------------------------------");
                addLore("&eSettings that you change here will");
                addLore("&esync across our network.");
                addLore("&7&m-------------------------------");
            }

        });

        addButton(new SwitcherButton(11, this, "&6Private Messages", "Everyone", "Friend Only", "Nobody") {
            @Override
            public void onStateChange(Integer state) {
                switch (state) {
                    case 0: getItem().setDurability((short) 10);
                        break;
                    case 1: getItem().setDurability((short) 12);
                        break;
                    case 2: getItem().setDurability((short) 8);
                        break;
                    default: break;
                }
                updateButton(this);
            }

            @Override
            public void onClick(ClickType type) {
                this.switchState();
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
            }

            @Override
            public void onCreation() {
                getItem().setDurability((short)10);
            }
        });

        addButton(new SwitcherButton(13, this, "&6Friend Requests", "Enabled", "Disabled") {
            @Override
            public void onStateChange(Integer state) {
                switch (state) {
                    case 0: getItem().setDurability((short) 10);
                        break;
                    case 1: getItem().setDurability((short) 8);
                        break;
                    default: break;
                }
                updateButton(this);
            }

            @Override
            public void onClick(ClickType type) {
                this.switchState();
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
            }

            @Override
            public void onCreation() {
                getItem().setDurability((short) 10);
            }
        });

        addButton(new SwitcherButton(15, this, "&6Message Pings", "Enabled", "Disabled") {
            @Override
            public void onStateChange(Integer state) {
                switch (state) {
                    case 0:
                        getItem().setDurability((short) 10);
                        break;
                    case 1: getItem().setDurability((short) 8);
                        break;
                    default: break;
                }
                updateButton(this);
            }

            @Override
            public void onClick(ClickType type) {
                this.switchState();
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1, 1);
            }

            @Override
            public void onCreation() {
                getItem().setDurability((short) 10);
            }
        });

    }

    @Override
    public void onClose() {
        getPlayer().sendMessage(Color.format("&7Using the power of the onClose menu event you can detect when the player closes a menu and save their settings after the fact!"));
    }
}
