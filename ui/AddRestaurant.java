package com.example.test01.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test01.R;

import java.io.IOException;

public class AddRestaurant extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView ivRestaurantImage;
    private EditText etRestaurantName, etPrepTime, etRating, etFoodName, etRestaurantDescription, etRestaurantPrice;
    private Button btnUploadImage, btnAddRestaurant;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_restaurant);

        // Initialize views
        ivRestaurantImage = findViewById(R.id.iv_food_image);
        btnUploadImage = findViewById(R.id.btn_upload_image);
        etRestaurantName = findViewById(R.id.et_restaurant_name);
        etPrepTime = findViewById(R.id.et_prep_time);
        etRating = findViewById(R.id.et_rating);
        etFoodName = findViewById(R.id.et_food_name);
        etRestaurantDescription = findViewById(R.id.et_restaurant_description);
        etRestaurantPrice = findViewById(R.id.et_restaurant_price);
        btnAddRestaurant = findViewById(R.id.btn_add_restaurant);

        // Set onClickListener for Upload Image button
        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        // Set onClickListener for Add Restaurant button
        btnAddRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRestaurantDetails();
            }
        });
    }

    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                ivRestaurantImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveRestaurantDetails() {
        String restaurantName = etRestaurantName.getText().toString().trim();
        String prepTime = etPrepTime.getText().toString().trim();
        String rating = etRating.getText().toString().trim();
        String foodName = etFoodName.getText().toString().trim();
        String restaurantDescription = etRestaurantDescription.getText().toString().trim();
        String restaurantPrice = etRestaurantPrice.getText().toString().trim();

        if (restaurantName.isEmpty() || prepTime.isEmpty() || rating.isEmpty() || foodName.isEmpty() ||
                restaurantDescription.isEmpty() || restaurantPrice.isEmpty() || imageUri == null) {
            Toast.makeText(this, "Please fill all fields and upload an image", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save restaurant details logic here (e.g., to a database, backend, etc.)
        Toast.makeText(this, "Restaurant added successfully!", Toast.LENGTH_SHORT).show();

        // Clear the form
        clearForm();
    }

    private void clearForm() {
        ivRestaurantImage.setImageResource(R.drawable.ic_food_placeholder);
        etRestaurantName.setText("");
        etPrepTime.setText("");
        etRating.setText("");
        etFoodName.setText("");
        etRestaurantDescription.setText("");
        etRestaurantPrice.setText("");
        imageUri = null;
    }
}
