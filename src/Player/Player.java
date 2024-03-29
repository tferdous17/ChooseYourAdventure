package src.Player;

import src.Items.Item;

public class Player extends Movement {
    private final String name;
    private final String classType; // only one classType for now
    private int currentHealth;
    private int maxHealth = 100;
    private double goldPouch;
    private int level;
    private int xp;
    private boolean isAlive;
    private int npcKills;
    private final Inventory inventory = new Inventory();


    public Player(String name) {
        super(0, 0);
        this.name = name;
        this.classType = "Adventurer";
        this.currentHealth = 100;
        this.goldPouch = 1000;
        this.level = 1;
        this.xp = 0;
        this.isAlive = true;
        this.npcKills = 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        if (currentHealth < 0) {
            return 0;
        } else {
            return currentHealth;
        }
    }

    public void increaseHealth(int health) {
        this.maxHealth += health;
        currentHealth = maxHealth;
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
        System.out.println("Gold: " + getGoldPouch());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void receiveDamage(int damageValue) {
        if (currentHealth > 0) {
            this.currentHealth -= damageValue;
        } else {
            isAlive = false;
            System.out.println("You've been utterly defeated!");
        }
    }


    public void viewStats() {
        System.out.println("Name: " + getName());
        System.out.println("Health: " + getHealth());
        System.out.println("NPC Kills: " + getKills());
        System.out.println("Total XP: " + getXP());
    }

    public int getKills() {
        return npcKills;
    }

    public void increaseKills() {
        npcKills++;
    }

    public void resetHealth() {
        currentHealth = maxHealth;
    }

}
