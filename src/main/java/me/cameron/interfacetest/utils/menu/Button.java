package me.cameron.interfacetest.utils.menu;

import me.cameron.interfacetest.utils.Color;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class Button {

    Integer slot;
    Menu parent;
    ItemStack item;
    Integer page;
    Boolean isStatic = false;
    Boolean visible = true;

    public Button(Integer slot, Menu parent, ItemStack item) {
        this(slot, parent, item, 0);
    }

    public Button(Integer slot, Menu parent, ItemStack item, Integer page) {
        this.slot = slot;
        this.parent = parent;
        this.item = item;
        this.page = page;
        onCreation();
    }

    public abstract void onClick(ClickType type);
    public abstract void onCreation();

    public ItemStack getItem() {
        if (!isVisible()) {
            return new ItemStack(Material.AIR);
        }
        return item;
    }

    public void setStatic(Boolean isStatic) {
        this.isStatic = isStatic;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public ItemMeta getMeta() {
        return getItem().getItemMeta();
    }

    public Integer getSlot() {
        return slot;
    }

    public Menu getMenu() {
        return parent;
    }

    public Integer getPage() {
        return page;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void clearLore() {

        ItemStack item = getItem();
        ItemMeta meta = getMeta();

        meta.setLore(new ArrayList<>());

        item.setItemMeta(meta);
        setItem(item);

    }

    public void addLore(String string) {

        ItemStack item = getItem();
        ItemMeta meta = getMeta();

        List<String> lore = new ArrayList<>();
        if (meta.hasLore()) {
            lore = meta.getLore();
        }
        lore.add(Color.format(string));
        meta.setLore(lore);

        item.setItemMeta(meta);
        setItem(item);

    }

    public void setTitle(String title) {

        ItemStack item = getItem();
        ItemMeta meta = getMeta();

        meta.setDisplayName(Color.format(title));

        item.setItemMeta(meta);
        setItem(item);

    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
        getMenu().updateButton(this);
    }

}
