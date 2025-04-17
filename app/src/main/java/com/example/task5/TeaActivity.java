package com.example.task5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TeaActivity extends AppCompatActivity {

    private class Tea {
        String name;
        int imageRes;

        Tea(String name, int imageRes) {
            this.name = name;
            this.imageRes = imageRes;
        }
    }

    private class TeaAdapter extends RecyclerView.Adapter<TeaAdapter.TeaViewHolder> {
        private List<Tea> teas;

        TeaAdapter(List<Tea> teas) {
            this.teas = teas;
        }

        @NonNull
        @Override
        public TeaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_tea, parent, false);
            return new TeaViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TeaViewHolder holder, int position) {
            Tea tea = teas.get(position);
            holder.tvName.setText(tea.name);
            holder.ivTea.setImageResource(tea.imageRes);
        }

        @Override
        public int getItemCount() {
            return teas.size();
        }

        class TeaViewHolder extends RecyclerView.ViewHolder {
            ImageView ivTea;
            TextView tvName;

            TeaViewHolder(View itemView) {
                super(itemView);
                ivTea = itemView.findViewById(R.id.iv_tea);
                tvName = itemView.findViewById(R.id.tv_tea_name);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea);

        List<Tea> teas = new ArrayList<>();
        teas.add(new Tea("Матча", R.drawable.tea_matcha));  // Убедитесь, что R.drawable.tea_matcha существует!
        teas.add(new Tea("Черный чай", R.drawable.tea_black));
        teas.add(new Tea("Зеленый чай", R.drawable.tea_green));

        RecyclerView rvTea = findViewById(R.id.rv_tea);
        rvTea.setLayoutManager(new LinearLayoutManager(this));  // Важно! Без этого список не отобразится
        rvTea.setAdapter(new TeaAdapter(teas));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Показывает стрелку "Назад"
        }
    }
}