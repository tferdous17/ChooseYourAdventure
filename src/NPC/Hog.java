package src.NPC;

public class Hog extends NPC {
    public Hog() {
        super("Hog", 125);
        setDamage(random.nextInt(25, 32));
        setXP(35);
    }
}
