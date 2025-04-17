package com.example.task5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class CocktailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktails);

        Spinner spinner = findViewById(R.id.spinner_cocktails);
        TextView tvSelected = findViewById(R.id.tv_selected_cocktail);

        List<String> cocktails = new ArrayList<>();
        cocktails.add("Star Martini");
        cocktails.add("Aperol Spritz");
        cocktails.add("Пиво светлое");
        cocktails.add("Пиво темное");
        cocktails.add("Смузи фруктовый");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, cocktails);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvSelected.setText("Выбран: " + cocktails.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvSelected.setText("Ничего не выбрано");
            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Показывает стрелку "Назад"
        }
    }
}