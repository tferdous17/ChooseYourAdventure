package src.Items.Weapons;

import src.Items.Item;

public class Durandal extends Weapon {
    String itemName;
    double itemPrice;

    public Durandal() {
        super("Durandal", 650);
        itemName = "Durandal";
        itemPrice = 650;
        setDamage(random.nextInt(65,70));
    }



}
