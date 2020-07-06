package me.cameron.interfacetest.example.menus;

import me.cameron.interfacetest.utils.menu.Button;
import me.cameron.interfacetest.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

public class AdministrativeProfileExampleMenu extends Menu {

    public AdministrativeProfileExampleMenu(String title, Player player, Plugin plugin) {
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

                setTitle("&6" + player.getDisplayName());
                addLore("&7&m-------------------------------");
                addLore("&eFirst Join&r: 4/3/2020 23:23:10");
                addLore("&eLast Join&r: 4/3/2020 23:23:10");
                addLore("&eUUID&r: " + player.getUniqueId());
                addLore("&7&m-------------------------------");
            }

        });

        addButton(new Button(11, this, new ItemStack(Material.BOOKSHELF)) {

            @Override
            public void onClick(ClickType type) {
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 0);
            }

            @Override
            public void onCreation() {
                setTitle("&6Punishment History");
                addLore("&7&m-------------------------------");
                addLore("&eMuted&r: &aNo");
                addLore("&eBanned&r: &cYes &8[&4Blacklisted&8]");
                addLore("&ePunishments&r: 8 on record");
                addLore("&7&m-------------------------------");
            }
        });

        addButton(new Button(12, this, new ItemStack(Material.WOOL)) {

            @Override
            public void onClick(ClickType type) {
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 0);
            }

            @Override
            public void onCreation() {
                setTitle("&6Grant History");
                addLore("&7&m-------------------------------");
                addLore("&eRank&r: &aDefault");
                addLore("&eGrants&r: 12 on record");
                addLore("&7&m-------------------------------");
                getItem().setDurability((short)5);
            }
        });

        addButton(new Button(14, this, new ItemStack(Material.BOOK)) {

            @Override
            public void onClick(ClickType type) {
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 0);
            }

            @Override
            public void onCreation() {
                setTitle("&6Miscellaneous");
                addLore("&7&m-------------------------------");
                addLore("&eTokens&r: 2500");
                addLore("&eTags&r: [&7Loser, Clown, Dab&r]");
                addLore("&7&m-------------------------------");
            }
        });

        addButton(new Button(15, this, new ItemStack(Material.RED_ROSE)) {

            @Override
            public void onClick(ClickType type) {
                player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 0);
            }

            @Override
            public void onCreation() {
                setTitle("&6Alt Accounts");
                addLore("&7&m-------------------------------");
                addLore("&eThis player's IP is connected to the following accounts");
                addLore("&r» PoopyHeah26");
                addLore("&r» StinkyBrain443");
                addLore("&r» IdkWhoXiistafIs");
                addLore("&eFurther more they have (5) more potential alt accounts");
                addLore("&eClick to view their alt tree");
                addLore("&7&m-------------------------------");
                getItem().setDurability((short)1);
            }
        });

    }
}
