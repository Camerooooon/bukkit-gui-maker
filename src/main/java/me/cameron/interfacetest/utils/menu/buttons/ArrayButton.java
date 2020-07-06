package me.cameron.interfacetest.utils.menu.buttons;

import me.cameron.interfacetest.utils.menu.Button;
import me.cameron.interfacetest.utils.menu.Menu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public abstract class ArrayButton extends Button {

    Integer startSlot;
    Integer endSlot;
    ItemStack fillerItem;
    ArrayList<Button> components = new ArrayList<>();

    public ArrayButton(Menu parent, Integer startSlot, Integer endSlot) {
        this(parent, startSlot, endSlot, new ItemStack(Material.AIR));
    }

    public ArrayButton(Menu parent, Integer startSlot, Integer endSlot, ItemStack fillerItem) {
        super(0, parent, new ItemStack(Material.INK_SACK));

        if (startSlot >= endSlot) {
            Bukkit.getConsoleSender().sendMessage("Failed to create ArrayButton element. Start slot cannot be >= to end slot!");
            return;
        }

        this.startSlot = startSlot;
        this.endSlot = endSlot;
        this.fillerItem = fillerItem;
        setStatic(true);
    }

    public Integer getSlots() {
        return endSlot - startSlot;
    }

    public Integer getStartSlot() {
        return startSlot;
    }

    public Integer getEndSlot() {
        return endSlot;
    }

    public void addButton(Button button) {
        components.add(button);
    }

    public ArrayList<Button> getComponents() {
        return components;
    }

    public Integer getPageCount() {
        return Math.round(getComponents().size() / (getSlots() + 1));
    }

    public void updateButtons() {
        int slot = 0;
        int page = 0;
        for (Button component : getComponents()) {
            component.setPage(page);
            component.setSlot(slot + getStartSlot());
            getMenu().addButton(component);
            slot++;
            if (slot % getSlots() == 0) {
                page++;
                slot = 0;
            }
        }
    }

}
