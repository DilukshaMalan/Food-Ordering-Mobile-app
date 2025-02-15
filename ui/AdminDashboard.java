package com.example.test01.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.test01.R;

public class AdminDashboard extends AppCompatActivity {


    private CardView manageFoodCard, manageRestaurantCard, managePromotionCard, orderControlCard, customerDetailsCard, analyticsCard;
    private Button logoutButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // Initialize the views
        manageFoodCard = findViewById(R.id.manageFoodCard);
        manageRestaurantCard = findViewById(R.id.manageRestaurantCard);
        managePromotionCard = findViewById(R.id.managePromotionCard);
        orderControlCard = findViewById(R.id.orderControlCard);
        customerDetailsCard = findViewById(R.id.customerDetailsCard);
        analyticsCard = findViewById(R.id.analyticsCard);
        logoutButton = findViewById(R.id.logout_button);

        // Set click listeners for the CardViews
        manageFoodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Manage Food Activity
                Intent intent = new Intent(AdminDashboard.this, ManageFood.class);
                startActivity(intent);
            }
        });

        manageRestaurantCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Manage Restaurant Activity
                Intent intent = new Intent(AdminDashboard.this, ManageRestaurant.class);
                startActivity(intent);
            }
        });

        managePromotionCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Manage Promotion Activity
                Intent intent = new Intent(AdminDashboard.this, ManagePromotion.class);
                startActivity(intent);
            }
        });

        orderControlCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Order Control Activity
                Intent intent = new Intent(AdminDashboard.this, OrderControl.class);
                startActivity(intent);
            }
        });

        customerDetailsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Customer Details Activity
                Intent intent = new Intent(AdminDashboard.this, CustomerDetails.class);
                startActivity(intent);
            }
        });

        analyticsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open Analytics Activity
                Intent intent = new Intent(AdminDashboard.this, Analytics.class);
                startActivity(intent);
            }
        });

        // Set click listener for the Log Out button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the log out process
                Toast.makeText(AdminDashboard.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
                // Redirect to login screen
                Intent intent = new Intent(AdminDashboard.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // End the current activity
            }
        });
    }
}
