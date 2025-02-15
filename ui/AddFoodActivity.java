package com.example.test01.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test01.R;

public class AddFoodActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    private ImageView ivFoodImage;
    private EditText etRestaurantName, etPrepTime, etEnergy, etRating, etFoodName, etFoodDescription, etFoodPrice;
    private Spinner spinnerCategory;
    private Button btnUploadImage, btnAddFood;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        ivFoodImage = findViewById(R.id.iv_food_image);
        etRestaurantName = findViewById(R.id.et_restaurant_name);
        etPrepTime = findViewById(R.id.et_prep_time);
        etEnergy = findViewById(R.id.et_energy);
        etRating = findViewById(R.id.et_rating);
        etFoodName = findViewById(R.id.et_food_name);
        etFoodDescription = findViewById(R.id.et_food_description);
        etFoodPrice = findViewById(R.id.et_food_price);
        btnUploadImage = findViewById(R.id.btn_upload_image);
        btnAddFood = findViewById(R.id.btn_add_food);

        btnUploadImage.setOnClickListener(v -> openGallery());

        btnAddFood.setOnClickListener(v -> addFood());
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE && data != null) {
            imageUri = data.getData();
            ivFoodImage.setImageURI(imageUri);
        }
    }

    private void addFood() {
        String restaurantName = etRestaurantName.getText().toString();
        String prepTime = etPrepTime.getText().toString();
        String energy = etEnergy.getText().toString();
        String rating = etRating.getText().toString();
        String foodName = etFoodName.getText().toString();
        String foodDescription = etFoodDescription.getText().toString();
        String foodPrice = etFoodPrice.getText().toString();
        String foodCategory = spinnerCategory.getSelectedItem().toString();

        if (restaurantName.isEmpty() || prepTime.isEmpty() || energy.isEmpty() || rating.isEmpty() ||
                foodName.isEmpty() || foodDescription.isEmpty() || foodPrice.isEmpty() || imageUri == null) {
            Toast.makeText(this, "Please fill in all fields and upload an image", Toast.LENGTH_SHORT).show();
        } else {
            // Handle the logic to add the food item (e.g., saving to a database)
            Toast.makeText(this, "Food added successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
