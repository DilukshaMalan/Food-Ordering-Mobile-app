package com.example.test01.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test01.R;

import java.util.ArrayList;
import java.util.List;

public class FoodMainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodAdapter adapter;
    private List<FoodItem> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_food);

        recyclerView = findViewById(R.id.recyclerView);
        Button btnAddFood = findViewById(R.id.btnAddFood);

        // Initialize food list
        foodList = new ArrayList<>();
        foodList.add(new FoodItem("Pizza", "Delicious cheese pizza", R.drawable.hamburger));
        foodList.add(new FoodItem("Burger", "Juicy beef burger", R.drawable.hamburger));
        foodList.add(new FoodItem("Pasta", "Creamy Alfredo pasta", R.drawable.hamburger));

        adapter = new FoodAdapter(this, foodList, new FoodAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {
                Toast.makeText(FoodMainActivity.this, "Edit " + foodList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick(int position) {
                foodList.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAddFood.setOnClickListener(v -> {
            // Add new food item
            foodList.add(new FoodItem("New Food", "New Description", R.drawable.ic_food_placeholder));
            adapter.notifyItemInserted(foodList.size() - 1);
        });
    }
}
