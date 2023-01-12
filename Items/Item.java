package Items;

public class Item {
    String itemName;
    double itemPrice;
    public Item() {
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
