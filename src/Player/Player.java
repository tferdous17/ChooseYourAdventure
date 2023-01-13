package src.Player;

import src.Items.Item;

public class Player extends Movement {
    private final String name;
    private final String classType; // only one classType for now
    private int health;
    private double goldPouch;
    private int level;
    private int xp;
    private final Inventory inventory = new Inventory();


    public Player(String name) {
        super(0, 0);
        this.name = name;
        this.classType = "Adventurer";
        this.health = 100;
        this.goldPouch = 10;
        this.level = 1;
        this.xp = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public double getGoldPouch() {
        return goldPouch;
    }

    public int getLevel() {
        return level;
    }

    public void increaseGoldPouch(double amount) {
        goldPouch += amount;
    }

    public void increaseXP(int n) {
        xp += n;
    }
    public int getXP() {
        return xp;
    }

    public void addToInventory(Item item) {
        inventory.addToInventory(item);
    }
    public void removeFromInventory(Item item) {
        inventory.removeFromInventory(item);
    }

    public void viewInventory() {
        inventory.printInventory();
    }

    public void viewStats() {
        System.out.println("---------STATS---------");
        System.out.println("Name: " + getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Gold: " + getGoldPouch());
    }


}
