package me.cameron.interfacetest.utils.menu.buttons;

import me.cameron.interfacetest.utils.menu.Button;
import me.cameron.interfacetest.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public abstract class SwitcherButton extends Button {

    List<String> states;
    Integer activeState = 0;

    public SwitcherButton(Integer slot, Menu parent, String title, String... states) {
        super(slot, parent, new ItemStack(Material.INK_SACK));
        this.states = Arrays.asList(states);
        setTitle(title);
        updateLore();
    }

    public abstract void onStateChange(Integer state);

    public Integer getState() {
        return activeState;
    }

    public void setState(Integer state) {
        activeState = state;
        updateLore();
        onStateChange(getState());
    }

    public Integer getStateCount() {
        return states.size() - 1;
    }

    public void switchState() {
        if (getStateCount() <= activeState++) {
            activeState = 0;
        }
        updateLore();
        onStateChange(getState());
    }

    private void updateLore() {
        clearLore();
        addLore("&7&m-------------------------------");
        for (int i = 0; i < states.size(); i++) {
            addLore((i == activeState ? "&6&l» &e" : "&6&l» &7") + states.get(i));
        }
        addLore("&eYou currently have &6" + states.get(activeState) + "&e selected.");
        addLore("&7&m-------------------------------");
        getMenu().updateButton(this);
    }

}
