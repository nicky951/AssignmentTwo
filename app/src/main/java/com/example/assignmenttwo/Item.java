package com.example.assignmenttwo;

public class Item {

    private int itemNum;
    private String name;
    private int price;
    private String description;
    private int intDrawableID;

    public Item(int itemNum, String name, int price, String description, int intDrawableID) {
        this.itemNum = itemNum;
        this.name = name;
        this.price = price;
        this.description = description;
        this.intDrawableID = intDrawableID;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIntDrawableID() {
        return intDrawableID;
    }

    public void setIntDrawableID(int intDrawableID) {
        this.intDrawableID = intDrawableID;
    }
}
