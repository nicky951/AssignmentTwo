package com.example.assignmenttwo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemDetail extends AppCompatActivity {

    private ImageView detailImage;
    private TextView detailName;
    private TextView detailDescription;
    private Button increment;
    private Button decrement;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detailed);

        Intent intent = getIntent();

        int itemNum = intent.getIntExtra("itemNum", 0);

        Item item = ItemDatabase.getItemById(itemNum);

        detailImage = findViewById(R.id.detailedimage);
        detailName = findViewById(R.id.detailedname);
        detailDescription = findViewById(R.id.detaileddescription);
        increment = findViewById(R.id.increment);
        decrement = findViewById(R.id.decrement);
        confirm = findViewById(R.id.confirm);

        detailImage.setImageResource(item.getIntDrawableID());
        detailName.setText(item.getName());
        detailDescription.setText(item.getDescription());

        detailName = findViewById(R.id.detailedname);
        detailDescription = findViewById(R.id.detaileddescription);
        increment = findViewById(R.id.increment);
        decrement = findViewById(R.id.decrement);
        confirm = findViewById(R.id.confirm);

    }
}
