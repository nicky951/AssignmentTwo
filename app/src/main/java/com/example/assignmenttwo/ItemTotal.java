package com.example.assignmenttwo;

public class ItemTotal {

    private Item item;
    private double totalPrice;
    private int totalQuantity;

    public ItemTotal(Item item, double totalPrice, int totalQuantity) {
        this.item = item;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
