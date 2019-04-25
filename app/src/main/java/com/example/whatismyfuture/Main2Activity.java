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
    private double weather = Double.parseDouble(MainActivity.temp);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView namesFuture = findViewById(R.id.namesFuture);
        namesFuture.setText(name + ":");
        TextView nameInfo = findViewById(R.id.nameInfo);
        nameInfo.setText(nameStory(name));
        TextView colorInfo = findViewById(R.id.colorInfo);
        colorInfo.setText(colorStory(color));
        TextView numberInfo = findViewById(R.id.numberInfo);
        numberInfo.setText(numberStory(number));
        TextView weatherInfo = findViewById(R.id.weatherInfo);
        weatherInfo.setText(weatherStory(weather));
        final Button returnButton = findViewById(R.id.returnButton);
        returnButton.setOnClickListener( v -> {
            openMainActivity();
        });
    }
    public static String nameStory(String names) {
        String name = names.toUpperCase();
        String toReturn;
        if (name.startsWith("E") || name.startsWith("A") || name.startsWith("O") || name.startsWith("I") || name.startsWith("U")) {
            toReturn = "In your future, you will be rich.";
        } else if (name.startsWith("J") || name.startsWith("K") || name.startsWith("L") || name.startsWith("C")) {
            toReturn = "In your future, you will be famous.";
        } else if (name.equals("GEOFF")) {
            toReturn = "In your future, you will remain bald";
        } else {
            toReturn = "In your future, you will be happy.";
        }
        return toReturn;
    }
    public static String colorStory(String colors) {
        String color = colors.toLowerCase();
        String toReturn;
        if (color.equals("red") || color.equals("blue") || color.equals("yellow")) {
            toReturn = "You will live in a " + color + " house";
        } else if (color.equals("black") || color.equals("green") || color.equals("purple")) {
            toReturn = "You will have a " + color + " car";
        } else if (color.equals("orange")) {
            toReturn = "You will have an orange collection";
        } else if (color.equals("pink") || color.equals("brown") || color.equals("white")) {
            toReturn = "You will have " + color + " hair";
        } else if (color.equals("grey") || color.equals("gray")) {
            toReturn = "You will have " + color + " phone";
        } else if (color.equals("illini orange")) {
            toReturn = "You will bleed orange and blue forever";
        } else {
            toReturn = "You will have a terminal illness";
        }
        return toReturn;
    }
    public static String numberStory(int number) {
        String toReturn;
        if (number < 0){
            toReturn = "and you will be a hermit.";
        } else if (number < 5) {
            toReturn = "and you will have " + number + " children.";
        } else if (number < 20) {
            toReturn = "and you will have " + number + " dogs and cats.";
        } else if (number < 50) {
            toReturn = "and you will marry at age " + number + ".";
        } else if (number < 122) {
            toReturn = "and you will die at age " + number + ".";
        } else if (number == 125) {
            toReturn = "and you will teach 125 more classes";
        } else {
            toReturn = "and you will own " + number + " plants.";
        }
        return toReturn;
    }
    public static String weatherStory(double temp) {
        String toReturn;
        if (temp < 32) {
            toReturn = "It might be freezing today, but it'll warm up soon! Keep pushing!";
        } else if (temp < 60) {
            toReturn = "You should go for a walk outside today!";
        } else if (temp < 90) {
            toReturn = "The weather looks great today, so get out there and get started on fulfilling your future!";
        } else {
            toReturn = "The weather seems a bit extreme today, maybe stay inside.";
        }
        return toReturn;
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
