package src.Items.Weapons;

import src.Items.Item;

import java.util.Random;

public class Weapon extends Item implements WeaponInterface {
    private int damage;
    protected Random random = new Random();
    public Weapon(String itemName, double itemPrice) {
        super(itemName, itemPrice, "Weapon");
    }

    public String getType() {
        return "Weapon";
    }

    @Override
    public int attack() {
        System.out.println("..With one swift strike, you inflict " + getDamage() + " damage with a " + getItemName() + "!");
        return getDamage();
    }

    @Override
    public void setDamage(int n) {
        this.damage = n;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
