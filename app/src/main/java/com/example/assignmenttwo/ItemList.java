package com.example.assignmenttwo;

import java.util.ArrayList;

public class ItemList {

    static ArrayList<ItemTotal> totalOrder = new ArrayList<ItemTotal>();

    public static void addOrder(ItemTotal totalInstance) {
        totalOrder.add(totalInstance);
    }

    public static ArrayList<ItemTotal> returnList() {
        return totalOrder;
    }

    public static void clearList(){
        totalOrder.clear();
    }

    public static void remove(int i) {
        ItemList.remove(i);
    }
}
