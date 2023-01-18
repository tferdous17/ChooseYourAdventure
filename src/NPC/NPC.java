package src.NPC;

import java.util.Random;

public class NPC {
    private final String npcType;
    private int health;
    private int damage = 15;
    private boolean isAlive;
    private int xp;
    protected Random random = new Random();


    public NPC(String npcType, int health) {
        this.npcType = npcType;
        this.health = health;
        isAlive = true;
    }

    public String getNpcType() {
        return npcType;
    }

    public void healthStatus() {
        if (!(isAlive())) {
            System.out.println(npcType + " has been defeated!");
        } else {
            System.out.println("The " + getNpcType() + " currently has " + health + " health! !GETHEALTH METHOD BEING CALLED!");
        }
    }

    public int getHealth() {
        if (health < 0) {
            return 0;
        }
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setXP(int xpAmount) {
        this.xp = xpAmount;
    }

    public int getXP() {
        return xp;
    }

    public void receiveDamage(int damageValue) {
        if (health > 0) {
            this.health -= damageValue;
        } else {
            isAlive = false;
            System.out.println(npcType + " has been defeated!");
        }
    }

    public int attack() {
        return damage;
    }

    @Override
    public String toString() {
        if (health <= 0) {
            return "You've killed the " + npcType + "!";
        } else {
            return "You've encountered a " + getNpcType() + "!\n" + "It has " + getHealth() + " health!";
        }
    }
}
