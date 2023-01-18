package src.NPC;

public class Lowly_Bandit extends NPC {
    public Lowly_Bandit() {
        super("Lowly Bandit", 120);
        setDamage(random.nextInt(23, 26));
        setXP(40);
    }
}
