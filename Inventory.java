import Items.Item;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();

    public void addToInventory(Item item) {
        if (!(inventory.contains(item))) {
            inventory.add(item);
        }
    }

    public void removeFromInventory(Item item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
        } else {
            throw new RuntimeException("ERROR: CAN NOT REMOVE ITEM FROM INVENTORY");
        }
    }

    public void printInventory() {
        for (Item i : inventory) {
            System.out.println(i.toString());
        }
    }

}
