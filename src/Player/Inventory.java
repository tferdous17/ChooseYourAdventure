package src.Player;

import src.Items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private final HashMap<String, Item> inventory = new HashMap<>();

    public void addToInventory(Item item) {
        if (item.getItemType().equals("Weapon")) {
            if (!(inventory.containsKey("Weapon"))) {
                if (!(inventory.containsValue(item))) {
                    inventory.put("Weapon", item);
                }
            }
        } else if (item.getItemType().equals("Armor")) {
            if (!(inventory.containsKey("Armor"))) {
                if (!(inventory.containsValue(item))) {
                    inventory.put("Armor", item);
                }
            }
        }
    }

    public void removeFromInventory(Item item) {
        if (inventory.containsValue(item)) {
            for (String s : inventory.keySet()) {
                if (inventory.get(s) == item) {
                    inventory.remove(s);
                }
            }
            System.out.println(item + " removed from inventory!");
        } else {
            throw new RuntimeException("ERROR: CAN NOT REMOVE ITEM FROM INVENTORY");
        }
    }

    public void printInventory() {
        System.out.println("----------INVENTORY----------");
        if (inventory.size() == 0) {
            System.out.println("Inventory is currently empty.");
        } else {
            for (Item i : inventory.values()) {
                System.out.println(i);
            }
        }
    }

    public Item lookThruInventory(String n) {
        if (inventory.containsKey(n)) {
            return inventory.get(n);
        }
        return null;
    }

}
