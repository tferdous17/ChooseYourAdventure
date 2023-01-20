package src.Items.Armor;

import src.Items.Item;
import src.Player.Player;

public class Armor extends Item implements ArmorInterface {
    int hpBuff;
    public Armor(String itemName, double itemPrice, int hpBuff) {
        super(itemName, itemPrice, "Armor");
        this.hpBuff = hpBuff;
    }

    public String getType() {
        return "Armor";
    }

    public void hpBuff(Player player) {
        player.increaseHealth(hpBuff);
    }
}
