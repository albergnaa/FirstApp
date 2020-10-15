package kvaepnrosh.firstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class ChoosingCityActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CityAdapter cityAdapter;
    private ImageView addCityImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_city);
        addCityImageView = findViewById(R.id.addCityImageView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> cities = Arrays.asList("Казань", "Хабаровск", "Москва");
        cityAdapter = new CityAdapter(cities, ChoosingCityActivity.this);
        recyclerView.setAdapter(cityAdapter);

        addCityImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //переход на экран добавления нового города
            }
        });
    }
}
