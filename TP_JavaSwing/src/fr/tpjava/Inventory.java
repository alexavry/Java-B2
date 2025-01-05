package fr.tpjava;
import fr.tpjava.inventory.Item;
import fr.tpjava.GameInventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public static List<Item> items = new ArrayList<>();

    public static void addItem(String name, int quantity) {
        for (Item item : items) {
            if (name.equals(item.name)) {
                item.quantity = quantity;
                return;
            }
        }
        items.add(new Item(name, quantity));
    }

    public static List<String> displayItems() {
        List<String> itemsList = new ArrayList<>();
        for (Item item : items) {
            itemsList.add(item.name + " : " + item.quantity);
        }
        return itemsList;
    }

    public static void removeItem(String name) {
        for (Item item : items) {
            if (name.equals(item.name)) {
                items.remove(item);
                return;
            }
        }
    }
}

