package com.example.assignmenttwo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

        Intent intent = getIntent();

        int itemNum = intent.getIntExtra("itemNum", 0);

        final Item item = ItemDatabase.getItemById(itemNum);

        detailImage = findViewById(R.id.detailedimage);
        detailName = findViewById(R.id.detailedname);
        detailDescription = findViewById(R.id.detaileddescription);
        increment = findViewById(R.id.increment);
        decrement = findViewById(R.id.decrement);
        quantity = findViewById(R.id.itemquantity);
        price = findViewById(R.id.total);
        confirm = findViewById(R.id.confirm);

        detailImage.setImageResource(item.getIntDrawableID());
        detailName.setText(item.getName());
        detailDescription.setText(item.getDescription());

        increment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int currentQuantity = Integer.parseInt((String)quantity.getText());
                currentQuantity += 1;

                price.setText("$"+ String.format("%.2f",(double)(item.getPrice() * currentQuantity)));
                quantity.setText(String.valueOf(currentQuantity));
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int currentQuantity = Integer.parseInt((String)quantity.getText());

                if(currentQuantity > 0) {
                    currentQuantity -= 1;

                    price.setText("$"+ String.format("%.2f",(double)(item.getPrice() * currentQuantity)));
                    quantity.setText(String.valueOf(currentQuantity));
                }
            }
        });

    }
}
