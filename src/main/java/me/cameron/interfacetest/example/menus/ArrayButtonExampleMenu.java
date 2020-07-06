package me.cameron.interfacetest.example.menus;

import me.cameron.interfacetest.utils.menu.Button;
import me.cameron.interfacetest.utils.menu.Menu;
import me.cameron.interfacetest.utils.menu.buttons.ArrayButton;
import me.cameron.interfacetest.utils.menu.buttons.PageButton;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class ArrayButtonExampleMenu extends Menu {

    public ArrayButtonExampleMenu(String title, Player player, Plugin plugin) {
        super(title, 5, player, plugin);

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
                addLore("&eBanned&r: &aNo");
                addLore("&eMuted&r: &cYes");
                addLore("&7&m-------------------------------");
                setStatic(true);
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

        Random random = new Random();
        /*
        * For the sake for an example just generate random "fake" punishments.
         */
        for (int i = 0; i < random.nextInt(60) + 25; i++) {

            arrayButton.addButton(new Button(0, this, new ItemStack(Material.BOOK)) {

                @Override
                public void onClick(ClickType type) {
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 0);
                }

                @Override
                public void onCreation() {

                    Integer randomInt = random.nextInt(5);

                    switch (randomInt) {
                        case 0:
                            setItem(new ItemStack(Material.INK_SACK));
                            getItem().setDurability((short)5);
                            setTitle("&6Permanent Ban &8[&a05/02/2020 23:15:10&8]");
                            addLore("&7&m-------------------------------");
                            addLore("&eIssued By&r: Poopyhead23");
                            addLore("&eReason &r: This guy is ugly person");
                            addLore("&7&m-------------------------------");
                            break;
                        case 1:
                            setItem(new ItemStack(Material.INK_SACK));
                            getItem().setDurability((short)13);
                            setTitle("&6Temporary Ban &8[&a05/02/2020 23:15:10&8]");
                            addLore("&7&m-------------------------------");
                            addLore("&eIssued By&r: StinkyBrain72");
                            addLore("&eReason&r: This guy is meanie head");
                            addLore("&eDuration&r: 30 days");
                            addLore("&eExpiration&r: 06/02/2020 23:15:10 &8(&715 days&8)");
                            addLore("&7&m-------------------------------");
                            break;
                        case 2:
                            setItem(new ItemStack(Material.BOOK));
                            setTitle("&6Permanent Mute &8[&c05/02/2020 23:15:10&8]");
                            addLore("&7&m-------------------------------");
                            addLore("&eIssued By&r: StinkyBrain72");
                            addLore("&eReason&r: This guy is meanie head");
                            addLore("&eRemoved By&r: Poopyhead23");
                            addLore("&eRemoval Reason&r: This guy is not meanie head");
                            addLore("&7&m-------------------------------");
                            break;
                        case 3:
                            setItem(new ItemStack(Material.PAPER));
                            setTitle("&6Temporary Mute &8[&c05/02/2020 23:15:10&8]");
                            addLore("&7&m-------------------------------");
                            addLore("&eIssued By&r: StinkyBrain72");
                            addLore("&eReason&r: This guy is meanie head");
                            addLore("&eDuration&r: 30 days");
                            addLore("&eRemoved By&r: Expiration");
                            addLore("&eRemoval Reason&r: Automatic Expiration");
                            addLore("&7&m-------------------------------");
                            break;
                        default:
                            setItem(new ItemStack(Material.REDSTONE_BLOCK));
                            setTitle("&6Blacklist &8[&a05/02/2020 23:15:10&8]");
                            addLore("&7&m-------------------------------");
                            addLore("&eIssued By&r: StinkyBrain72");
                            addLore("&eReason&r: This guy is meanie head");
                            addLore("&7&m-------------------------------");

                    }
                }

            });

        }

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
