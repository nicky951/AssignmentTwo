package com.example.assignmenttwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ItemDatabase {

    public static Item getItemById(int itemNum) {
        return items.get(itemNum);
    }

    public static ArrayList<Item> getAllItems() {
        return new ArrayList<Item>((List) Arrays.asList(items.values().toArray()));
    }

    private static final LinkedHashMap<Integer, Item> items = new LinkedHashMap<>();

    static {
        items.put(1, new Item(1, "BK Big One",6.50, "Burger Kong's Classic Big Burger",R.drawable.burger));
        items.put(2, new Item(2,"BK Fries",3.50,"Classic Salted Fries",R.drawable.fries));
        items.put(3, new Item(3,"BK Wings", 7,"10 BK Hot Wings",R.drawable.wings));
        items.put(4, new Item(4,"BK Nuggets", 4.50,"Golden BK Nuggets with Sauce",R.drawable.nuggets));
        items.put(5, new Item(5,"BK Fish n' Chips", 5,"Crispy Fried Fish with Tartare Sauce",R.drawable.fish));
        items.put(6, new Item(6,"BK Chicken", 10,"Burger Kong famous Charcoal Grilled Chicken with fresh Garlic Sauce",R.drawable.chicken));
        items.put(7, new Item(7,"BK Chicken Salad", 4.50,"Fresh Chicken Salad for those seeking a healthy alternative!",R.drawable.salad));
        items.put(8, new Item(8,"BK Butter Chicken", 9, "New BK Chicken Curry with Fried Egg",R.drawable.curry));
        items.put(9, new Item(9,"Meal Deal", 8, "BK Big One with one Large Drink",R.drawable.fastfood));
        items.put(10, new Item(10,"BK Rack O' Lamb", 12,"Sweet BBQ Glazed Lamb Rack",R.drawable.lamb));
        items.put(11, new Item(11,"BK Shish", 6, "2 Chicken Shish with Hommus",R.drawable.kebab));
        items.put(12, new Item(12,"Large Drink", 2,"Any Large Soft Drink", R.drawable.soda));
        items.put(13, new Item(13,"Sparkling Water",4.50,"Premium Sparkling Water with Ice",R.drawable.water));
        items.put(14, new Item(14,"Fresh Juice",3,"Freshly Squeezed Juice",R.drawable.juice));
        items.put(15, new Item(15,"BK House Vodka", 200,"BK's World Reknown House Destilled Vodka",R.drawable.vodka));
    }
}
