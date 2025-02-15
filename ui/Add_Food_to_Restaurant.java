package com.example.test01.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test01.R;
import com.squareup.picasso.Picasso;

public class Add_Food_to_Restaurant extends AppCompatActivity {

    private EditText imageUrlEditText;
    private ImageView foodImageView;
    private Button uploadImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_to_restaurant);

        imageUrlEditText = findViewById(R.id.Image_url);
        foodImageView = findViewById(R.id.iv_food_image);
        uploadImageButton = findViewById(R.id.btn_upload_image);

        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageUrl = imageUrlEditText.getText().toString().trim();

                if (!imageUrl.isEmpty()) {
                    // Load the image using Picasso library
                    Picasso.get()
                            .load(imageUrl)
                            .placeholder(R.drawable.ic_food_placeholder) // Optional placeholder

                            .into(foodImageView);
                } else {
                    Toast.makeText(Add_Food_to_Restaurant.this, "Please enter a valid URL", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
