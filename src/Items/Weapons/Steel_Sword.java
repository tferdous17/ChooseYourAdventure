package src.Items.Weapons;

import src.Items.Item;

public class Steel_Sword extends Weapon {
    String itemName;
    double itemPrice;

    public Steel_Sword() {
        super("Steel Sword", 150);
        itemName = "Steel Sword";
        itemPrice = 150;
        setDamage(random.nextInt(31,35));
    }



}
