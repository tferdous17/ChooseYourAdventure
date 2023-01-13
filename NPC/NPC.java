package NPC;

public class NPC {
    String npcType;
    int health;

    public NPC(String npcType, int health) {
        this.npcType = npcType;
        this.health = health;
    }

    public String getNpcType() {
        return npcType;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "You've encountered a " + npcType + "!\n" + "Health: " + health;
    }
}
