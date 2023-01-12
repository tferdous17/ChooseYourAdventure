import Items.*;

import java.util.ArrayList;

public class Player {
    String name;
    String classType = "Adventurer"; // only one classType for now
    private Inventory inventory = new Inventory();


    public Player(String name) {
        this.name = name;
    }


    public void testing() {
        System.out.println("Adding rusty sword & leather armor");
        Item sword = new Rusty_Sword();
        Item armor = new Leather_Armor();
        inventory.addToInventory(sword);
        inventory.addToInventory(armor);
        System.out.println("Added rusty sword & leather armor");
        System.out.println();

        inventory.printInventory();
    }


}
