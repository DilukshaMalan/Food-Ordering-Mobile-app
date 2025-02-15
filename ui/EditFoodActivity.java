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

public class EditFoodActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView ivFoodImage;
    private EditText etFoodName, etRestaurantName, etPrepTime, etEnergy, etRating, etFoodDescription, etFoodPrice;
    private Button btnUploadImage, btnSaveFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_menu_item);

        // Initialize UI components
        ivFoodImage = findViewById(R.id.iv_food_image);
        etFoodName = findViewById(R.id.et_food_name);
        etRestaurantName = findViewById(R.id.et_restaurant_name);
        etPrepTime = findViewById(R.id.et_prep_time);
        etEnergy = findViewById(R.id.et_energy);
        etRating = findViewById(R.id.et_rating);
        etFoodDescription = findViewById(R.id.et_food_description);
        etFoodPrice = findViewById(R.id.et_food_price);
        btnUploadImage = findViewById(R.id.btn_upload_image);
        btnSaveFood = findViewById(R.id.btn_add_food);

        // Set onClick listeners for buttons
        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        btnSaveFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFoodDetails();
            }
        });
    }

    // Method to open image picker
    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    // Handle the result of the image picker
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                ivFoodImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Failed to load image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Method to save food details
    private void saveFoodDetails() {
        String foodName = etFoodName.getText().toString().trim();
        String restaurantName = etRestaurantName.getText().toString().trim();
        String prepTime = etPrepTime.getText().toString().trim();
        String energy = etEnergy.getText().toString().trim();
        String rating = etRating.getText().toString().trim();
        String foodDescription = etFoodDescription.getText().toString().trim();
        String foodPrice = etFoodPrice.getText().toString().trim();

        if (foodName.isEmpty() || restaurantName.isEmpty() || prepTime.isEmpty() ||
                energy.isEmpty() || rating.isEmpty() || foodDescription.isEmpty() || foodPrice.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save food details to database or pass to next activity
        // Here, just showing a Toast for demo
        Toast.makeText(this, "Food details saved", Toast.LENGTH_SHORT).show();

        // After saving, you might want to clear the fields or navigate away
    }
}
