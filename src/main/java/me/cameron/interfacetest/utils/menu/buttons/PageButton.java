package me.cameron.interfacetest.utils.menu.buttons;

import me.cameron.interfacetest.utils.menu.Button;
import me.cameron.interfacetest.utils.menu.Menu;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

public abstract class PageButton extends Button {

    public boolean forward;

    public PageButton(Integer slot, Menu parent, ItemStack item, Boolean forward) {
        super(slot, parent, item);
        this.forward = forward;
        onPageTurn();
    }

    public void onPageTurn() {
        if (forward) {
            if (getMenu().pageCount() == getMenu().getPage()) {
                setVisible(false);
            } else {
                setVisible(true);
            }
        } else {
            if (getMenu().getPage() == 0) {
                setVisible(false);
            } else {
                setVisible(true);
            }
        }
    }

}
