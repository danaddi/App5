package com.example.task5;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeActivity extends AppCompatActivity {

    private ArrayList<String> coffeeList = new ArrayList<>(Arrays.asList(
            "Латте", "Капучино", "Раф", "Американо", "Эспрессо"));
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        ListView listView = findViewById(R.id.lv_coffee);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, coffeeList);
        listView.setAdapter(adapter);

        EditText etCoffee = findViewById(R.id.et_coffee);
        Button btnAdd = findViewById(R.id.btn_add_coffee);
        Button btnRemove = findViewById(R.id.btn_remove_coffee);

        btnAdd.setOnClickListener(v -> {
            String newCoffee = etCoffee.getText().toString().trim();
            if (!newCoffee.isEmpty()) {
                coffeeList.add(newCoffee);
                adapter.notifyDataSetChanged();
                etCoffee.setText("");
            }
        });

        btnRemove.setOnClickListener(v -> {
            SparseBooleanArray checked = listView.getCheckedItemPositions();
            for (int i = checked.size() - 1; i >= 0; i--) {
                if (checked.valueAt(i)) {
                    coffeeList.remove(checked.keyAt(i));
                }
            }
            listView.clearChoices();
            adapter.notifyDataSetChanged();
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Показывает стрелку "Назад"
        }
    }
}