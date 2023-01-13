package src.Items.Weapons;

import src.Items.Item;

public class Weapon extends Item implements WeaponInterface {
    int damage;
    public Weapon(String itemName, double itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public void damage() {

    }

    @Override
    public int getDamage() {
        return damage;
    }
}
