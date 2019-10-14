package org.katas.refactoring;

public class LineItem {
    private String itemDescription;
    private double price;
    private int quantity;

    public LineItem(String itemDescription, double price, int quantity) {
        this.itemDescription = itemDescription;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return itemDescription;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return price * quantity;
    }
}