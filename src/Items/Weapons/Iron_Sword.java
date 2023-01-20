package src.Items.Weapons;

import src.Items.Item;

public class Iron_Sword extends Weapon {
    String itemName;
    double itemPrice;

    public Iron_Sword() {
        super("Iron Sword", 75);
        itemName = "Iron Sword";
        itemPrice = 75;
        setDamage(random.nextInt(24,28));
    }



}
