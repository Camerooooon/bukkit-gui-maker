package me.cameron.interfacetest.utils.menu;

import me.cameron.interfacetest.utils.Color;
import me.cameron.interfacetest.utils.menu.buttons.ArrayButton;
import me.cameron.interfacetest.utils.menu.buttons.PageButton;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public abstract class Menu {

    static ArrayList<Menu> menus = new ArrayList<>();

    String menuTitle;
    Integer menuRows;
    Player menuPlayer;
    Integer menuPage;
    ArrayList<Button> buttons = new ArrayList<>();
    Inventory inventory;

    public Menu(String title, Integer rows, Player player, Plugin plugin) {
        this(title, rows, player, 0, plugin);
    }

    public Menu(String title, Integer rows, Player player, Integer page, Plugin plugin) {
        menuTitle = title;
        menuRows = rows;
        menuPage = page;
        menuPlayer = player;
        player.closeInventory();
        inventory = Bukkit.createInventory(player, rows*9, Color.format(title));
        player.openInventory(inventory);
        menus.add(this);
    }

    public void onClose() {

    }

    public static ArrayList<Menu> getMenus() {
        return menus;
    }

    public Integer getSlots() {
        return menuRows*9;
    }

    public Integer getRows() {
        return menuRows;
    }

    public void setRows(Integer rows) {
        menuRows = rows;
    }

    public Player getPlayer() {
        return menuPlayer;
    }

    public String getTitle() {
        return menuTitle;
    }

    public Integer pageCount() {
        int highest = 0;
        for (Button button : getButtons()) {
            if (button instanceof ArrayButton) {
                highest = ((ArrayButton) button).getPageCount();
                continue;
            }
            if (button.getPage() > highest) {
                highest = button.getPage();
            }
        }
        return highest;
    }

    public Integer getPage() {
        return menuPage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setPage(Integer page) {
        menuPage = page;

        for (Button button : getButtons()) {
            if (button instanceof PageButton) {
                ((PageButton) button).onPageTurn();
            }
        }

        updateInventory();
    }

    public void updateButton(Button button) {

        if (button instanceof ArrayButton) {
            ArrayButton arrayButton = (ArrayButton) button;
            for (Button component : arrayButton.getComponents()) {
                updateButton(component);
            }
            return;
        }

        if (button.getPage() != getPage() && !button.isStatic()) {
            return;
        }

        Inventory inventory = getInventory();
        inventory.setItem(button.getSlot(), button.getItem());
        setInventory(inventory);

    }

    public void addButton(Button... buttons) {
        for (Button button : buttons) {
            if (button.getPage() != getPage() && !button.isStatic()) {
                continue;
            }
            getButtons().add(button);
        }
        updateInventory();
    }

    public void updateInventory() {
        getInventory().clear();
        for (Button button : getButtons()) {
            updateButton(button);
        }
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }

}
