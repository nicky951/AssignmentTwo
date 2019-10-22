package com.example.assignmenttwo;

import java.util.ArrayList;

public class ItemList {

    static ArrayList<ItemTotal> totalOrder = new ArrayList<ItemTotal>();

    public static void addOrder(ItemTotal totalInstance) {
        totalOrder.add(totalInstance);

        System.out.println("Added instance" + totalInstance.getTotalPrice());
    }

    public static ArrayList<ItemTotal> returnList() {
        return totalOrder;
    }
}
