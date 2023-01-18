package src.NPC;

public class Hog extends NPC {
    public Hog() {
        super("Hog", 105);
        setDamage(random.nextInt(21, 24));
        setXP(30);
    }
}
