package com.example.task5;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_coffee).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CoffeeActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_tea).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TeaActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_food).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FoodActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_cocktails).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CocktailsActivity.class);
            startActivity(intent);
        });
    }
}