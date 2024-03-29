package com.example.assignmenttwo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetail extends AppCompatActivity {

    private ImageView detailImage;
    private TextView detailName;
    private TextView detailDescription;
    private TextView price;
    private TextView quantity;
    private Button increment;
    private Button decrement;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detailed);

        //Opens up a detailed view of the Item from recycler when clicked
        Intent intent = getIntent();

        int itemNum = intent.getIntExtra("itemNum", 0);

        final Item item = ItemDatabase.getItemById(itemNum);

        //Attach Id of Elements
        detailImage = findViewById(R.id.detailedimage);
        detailName = findViewById(R.id.detailedname);
        detailDescription = findViewById(R.id.detaileddescription);
        increment = findViewById(R.id.increment);
        decrement = findViewById(R.id.decrement);
        quantity = findViewById(R.id.itemquantity);
        price = findViewById(R.id.total);
        confirm = findViewById(R.id.confirm);

        //Data setting and onclick logic
        detailImage.setImageResource(item.getIntDrawableID());
        detailName.setText(item.getName());
        detailDescription.setText(item.getDescription());

        //Increment Logic
        increment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int currentQuantity = Integer.parseInt((String)quantity.getText());
                currentQuantity += 1;

                price.setText(String.format("%.2f",(double)(item.getPrice() * currentQuantity)));
                quantity.setText(String.valueOf(currentQuantity));
            }
        });

        //Decrement Logic
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int currentQuantity = Integer.parseInt((String)quantity.getText());

                if(currentQuantity > 0) {
                    currentQuantity -= 1;

                    price.setText(String.format("%.2f",(double)(item.getPrice() * currentQuantity)));
                    quantity.setText(String.valueOf(currentQuantity));
                }
            }
        });

        //Logic to add quantity, price and item to a list once user clicks confirm
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int currentQuantity = Integer.parseInt((String)quantity.getText());
                double currentPrice = Double.parseDouble((String)price.getText());

                if (currentPrice > 0) {
                    ItemTotal itemTotal = new ItemTotal(item, currentPrice, currentQuantity);

                    ItemList.addOrder(itemTotal);

                    Context context = v.getContext();

                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);

                } else {
                    Context context = getApplicationContext();

                    //Ensures warning pops up when user tries to order 0 items
                    Toast toast = Toast.makeText(context,"You cannot Order 0 Items", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
    }
}
