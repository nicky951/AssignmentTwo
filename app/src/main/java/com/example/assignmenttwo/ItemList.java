package com.example.assignmenttwo;

import java.util.ArrayList;

public class ItemList {

    //ArrayList containing ItemTotal objects which have the Total Price, Quantity and Item
    static ArrayList<ItemTotal> totalOrder = new ArrayList<ItemTotal>();

    //Method to add order to list when user clicks confirm from detailed item page
    public static void addOrder(ItemTotal totalInstance) {
        totalOrder.add(totalInstance);
    }

    //Returns list for use in order fragment
    public static ArrayList<ItemTotal> returnList() {
        return totalOrder;
    }

    //Used when user orders
    public static void clearList(){
        totalOrder.clear();
    }
}
