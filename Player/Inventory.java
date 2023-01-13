package Player;

import Items.Item;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();

    public void addToInventory(Item item) {
        if (!(inventory.contains(item))) {
            inventory.add(item);
            System.out.println(item + " added to inventory!");
        }
    }

    public void removeFromInventory(Item item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            System.out.println(item + " removed from inventory!");
        } else {
            throw new RuntimeException("ERROR: CAN NOT REMOVE ITEM FROM INVENTORY");
        }
    }

    public void printInventory() {
        System.out.println("----------INVENTORY----------");
        inventory.forEach(System.out::println);
    }

}
