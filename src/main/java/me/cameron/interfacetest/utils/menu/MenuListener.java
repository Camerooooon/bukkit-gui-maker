package me.cameron.interfacetest.utils.menu;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {

        for (Menu menu : Menu.getMenus()) {

            if (!event.getInventory().equals(menu.getInventory())) {
                continue;
            }

            event.setCancelled(true);

            if (event.getCurrentItem() == null) {
                continue;
            }

            for (Button button : menu.getButtons()) {
                if (button.getItem().equals(event.getCurrentItem())) {
                    button.onClick(event.getClick());
                }
            }
        }

    }

    @EventHandler
    public void onInventoryCloseEvent(InventoryCloseEvent event) {

        for (Menu menu : Menu.getMenus()) {

            if (!event.getInventory().equals(menu.getInventory())) {
                continue;
            }

            menu.onClose();
            Menu.getMenus().remove(menu);
            return;

        }

    }

}
