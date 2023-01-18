package src.NPC;

public class Rogue_Guard extends NPC {
    public Rogue_Guard() {
        super("Rogue Guard", 145);
        setDamage(random.nextInt(26, 29));
        setXP(45);
    }
}
