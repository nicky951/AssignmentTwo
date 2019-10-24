package com.example.assignmenttwo;

//Item Class
public class Item {

    //Item attributes
    private int itemNum;
    private String name;
    private double price;
    private String description;
    private int intDrawableID;

    //Item Constructor
    public Item(int itemNum, String name, double price, String description, int intDrawableID) {
        this.itemNum = itemNum;
        this.name = name;
        this.price = price;
        this.description = description;
        this.intDrawableID = intDrawableID;
    }

    //Getters and Setters
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
