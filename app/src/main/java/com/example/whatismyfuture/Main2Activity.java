package com.example.whatismyfuture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    private String name = MainActivity.name;
    private String color = MainActivity.color;
    private int number = MainActivity.number;
    private double weather = MainActivity.currentTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView nameInfo = findViewById(R.id.nameInfo);
        nameInfo.setText(nameStory(name));
        TextView colorInfo = findViewById(R.id.colorInfo);
        colorInfo.setText(colorStory(color));
        TextView numberInfo = findViewById(R.id.numberInfo);
        numberInfo.setText(numberStory(number));
        TextView weatherInfo = findViewById(R.id.weatherInfo);
        weatherInfo.setText(Double.toString(weather));
        final Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener( v -> {
            openMainActivity();
        });
    }
    public static String nameStory(String name) {
        if (name.startsWith("E")) {
            String toReturn = "In your future, you will get money";
        }
        return name;
    }
    public static String colorStory(String color) {
        return color;
    }
    public static String numberStory(int number) {
        return Integer.toString(number);
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
