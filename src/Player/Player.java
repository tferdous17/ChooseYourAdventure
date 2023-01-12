package src.Player;

public class Player extends Movement {
    private final String name;
    private final String classType; // only one classType for now
    private int health;
    private double goldPouch;
    private final Inventory inventory = new Inventory();


    public Player(String name) {
        super(0, 0);
        this.name = name;
        this.classType = "Adventurer";
        this.health = 100;
        this.goldPouch = 10;
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

    public void increaseGoldPouch(double amount) {
        goldPouch += amount;
    }


}
