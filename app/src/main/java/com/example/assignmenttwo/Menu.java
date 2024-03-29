package com.example.assignmenttwo;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
//Code for Fragment for Menu Screen
public class Menu extends Fragment {

    private RecyclerView recyclerView;

    //New Instance of Menu
    public static Menu Menu() {

        Menu fragment = new Menu();
        return fragment;
    }


    //Set adapter and inflate the different items within the recycler view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        recyclerView = view.findViewById(R.id.recyclermenu);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        ItemAdapter itemAdapter = new ItemAdapter();

        itemAdapter.setData(ItemDatabase.getAllItems());
        recyclerView.setAdapter(itemAdapter);

        return view;
    }

}
