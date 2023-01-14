package src.Items;

public class Item {
    private final String itemName;
    private final double itemPrice;
    private final String itemType;
    public Item(String itemName, double itemPrice, String itemType) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemName.equals(item.itemName);
    }
}
