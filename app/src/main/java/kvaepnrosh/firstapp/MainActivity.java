package kvaepnrosh.firstapp;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout constraintLayout = findViewById(R.id.mainWindow);
        final TextView txtWeatherType = findViewById(R.id.weatherTypeTextView);
        final ImageView imgWeatherType = findViewById(R.id.weatherTypeImageView);
        Button btnSunny = findViewById(R.id.sunnyButton);
        Button btnCloudy = findViewById(R.id.cloudyButton);
        Button btnRainy = findViewById(R.id.rainyButton);

        btnSunny.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtWeatherType.setText(R.string.sunny);
                imgWeatherType.setImageResource(R.mipmap.sunny);
                constraintLayout.setBackgroundResource(R.color.colorSunnyBack);
            }
        });

        btnCloudy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtWeatherType.setText(R.string.cloudy);
                imgWeatherType.setImageResource(R.mipmap.cloudy);
                constraintLayout.setBackgroundResource(R.color.colorCloudyBack);
            }
        });

        btnRainy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtWeatherType.setText(R.string.rainy);
                imgWeatherType.setImageResource(R.mipmap.rainy);
                constraintLayout.setBackgroundResource(R.color.colorRainyBack);
            }
        });
    }
}