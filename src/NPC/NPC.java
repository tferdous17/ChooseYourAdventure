package src.NPC;

public class NPC {
    String npcType;
    int health;
    int damage;

    public NPC(String npcType, int health) {
        this.npcType = npcType;
        this.health = health;
        this.damage = 15;
    }

    public String getNpcType() {
        return npcType;
    }

    public int getHealth() {
        return health;
    }

    public int attack() {
        return damage;
    }

    @Override
    public String toString() {
        return "You've encountered a " + npcType + "!\n" + "Health: " + health;
    }
}
