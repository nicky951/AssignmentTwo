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
public class Order extends Fragment {

    private RecyclerView recyclerView;

    public static Order Order() {
        // Required empty public constructor
        Order fragment = new Order();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        recyclerView = view.findViewById(R.id.recyclerorder);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        TotalAdapter totalAdapter = new TotalAdapter();

        totalAdapter.setData(ItemList.returnList());
        recyclerView.setAdapter(totalAdapter);

        return view;
    }

}
