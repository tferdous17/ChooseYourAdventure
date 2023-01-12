package Items;

public class Item {
    private final String itemName;
    private final double itemPrice;
    public Item(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return "Item: " + getItemName() + ", Value: " + getItemPrice() + " G";
    }
}
