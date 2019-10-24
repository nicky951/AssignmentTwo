package com.example.assignmenttwo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 */

//Code for Fragment for Order Screen
public class Order extends Fragment {

    private RecyclerView recyclerView;

    //New instance of Order
    public static Order Order() {
        Order fragment = new Order();
        return fragment;
    }


    //Sets data in Recycler View for Orders screen
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_order, container, false);

        recyclerView = view.findViewById(R.id.recyclerorder);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        TotalAdapter totalAdapter = new TotalAdapter();

        totalAdapter.setData(ItemList.returnList());
        recyclerView.setAdapter(totalAdapter);

        //Logic to calculate total price of all item orders using the list of totalorder objects
        double total = 0;

        for(int i = 0; i < ItemList.returnList().size(); i++) {
            total += ItemList.returnList().get(i).getTotalPrice();
        }
        TextView price = view.findViewById(R.id.finalprice);
        price.setText("$" + String.format("%.2f", total));

        //Onclicklistener logic for confirm button
        Button confirmOrder = view.findViewById(R.id.confirmbutton);

        confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Popup that advises the user that the items has been ordered.
                Toast toast = Toast.makeText(getContext(), "Order Confirmed" , Toast.LENGTH_SHORT );
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                ItemList.clearList();

                //Reattach fragment to refresh the page
                final FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainframe, Order.Order());
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
