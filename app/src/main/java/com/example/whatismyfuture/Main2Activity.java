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
        String toReturn;
        if (name.startsWith("E") || name.startsWith("A") || name.startsWith("O") || name.startsWith("I") || name.startsWith("U")) {
            toReturn = "In your future, you will be rich.";
        } else if (name.startsWith("J") || name.startsWith("K") || name.startsWith("L") || name.startsWith("C")){
            toReturn = "In your future, you will be famous.";
        } else {
            toReturn = "In your future, you will be happy.";
        }
        return toReturn;
    }
    public static String colorStory(String color) {
        String toReturn;
        if (color.equals("red") || color.equals("blue") || color.equals("yellow")) {
            toReturn = "You will live in a " + color + " house.";
        } else if (color.equals("orange") || color.equals("green") || color.equals("purple")) {
            toReturn = "You will have a " + color + " car.";
        } else {
            toReturn = "You will have a terminal illness.";
        }
        return toReturn;
    }
    public static String numberStory(int number) {
        String toReturn;
        if (number < 0){
            toReturn = "You will be a hermit.";
        } else if (number < 5) {
            toReturn = "You will have " + number + " children.";
        } else if (number < 20) {
            toReturn = "You will have " + number + " dogs and cats.";
        } else if (number < 50) {
            toReturn = "You will marry at age " + number + ".";
        } else {
            toReturn = "You will die at age " + number + ".";
        }
        return toReturn;
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
