package kvaepnrosh.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Constants {

    private static final String TEMP_KEY = "TEMP_KEY";
    private static final String SWITCH_KEY = "SWITCH_KEY";
    private final static int REQUEST_CODE = 1;

    private ConstraintLayout constraintLayout;
    private TextView txtCityName;
    private TextView txtWeatherType;
    private ImageView imgWeatherType;
    private Switch tempSwitch;
    private EditText tempEditText;
    private TextView tempTextView;
    private Button infoButton;
    private Button chooseCityButton;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode!=REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }else{
            txtCityName= findViewById(R.id.cityTextView);
            String cityName = data.getStringExtra(CITY_NAME);
            txtCityName.setText(cityName);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.mainWindow);
        txtWeatherType = findViewById(R.id.weatherTypeTextView);
        imgWeatherType = findViewById(R.id.weatherTypeImageView);
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

        tempEditText = findViewById(R.id.tempEditText);
        Button btnOk = findViewById(R.id.okButton);
        tempTextView = findViewById(R.id.temperatureTextView);
        tempSwitch = findViewById(R.id.tempSwitch);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tempEditText.getText().toString().equals("")) {
                    tempTextView.setText(tempEditText.getText().toString().replaceAll("\\s+", ""));
                    tempEditText.setText("");
                }
            }
        });

        tempSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String temp = tempTextView.getText().toString();
                if (isChecked) {
                    double tempF = Double.valueOf(temp) * 9 / 5 + 32;
                    tempTextView.setText(String.valueOf(tempF));
                } else {
                    double tempC = 5 * (Double.valueOf(temp) - 32) / 9;
                    tempTextView.setText(String.valueOf((int) tempC));
                }
            }
        });

        chooseCityButton = findViewById(R.id.changeCityButton);
        chooseCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChoosingCityActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        txtCityName= findViewById(R.id.cityTextView);
        infoButton = findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri address = Uri.parse("https://ru.wikipedia.org/wiki/"+txtCityName.getText().toString());
                Intent infoIntent = new Intent(Intent.ACTION_VIEW, address);
                startActivity(infoIntent);
            }
        });

        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        Log.d("MainActivity", instanceState + " - onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", " - onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", " - onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", " - onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", " - onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", " - onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", " - onRestart()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView tempTextView = findViewById(R.id.temperatureTextView);
        outState.putString(TEMP_KEY, tempTextView.getText().toString());

        Switch tempSwitch = findViewById(R.id.tempSwitch);
        outState.putBoolean(SWITCH_KEY, tempSwitch.isChecked());

        Log.d("MainActivity", " - onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView tempTextView = findViewById(R.id.temperatureTextView);
        tempTextView.setText(savedInstanceState.getString(TEMP_KEY));

        Switch tempSwitch = findViewById(R.id.tempSwitch);
        tempSwitch.setChecked(savedInstanceState.getBoolean(SWITCH_KEY));

        Log.d("MainActivity", " - onRestoreInstanceState()");
    }
}
