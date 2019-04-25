package com.example.whatismyfuture;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    public static double currentTemp;
    public static String name;
    public static String color;
    public static int number;
    public static int zip;
    public static String temp;
    EditText inputName;
    EditText inputColor;
    EditText inputNumber;
    EditText inputZip;

    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = (EditText) findViewById(R.id.inputName);
        inputColor = (EditText) findViewById(R.id.inputColor);
        inputNumber = (EditText) findViewById(R.id.inputNumber);
        inputZip = (EditText) findViewById(R.id.inputZip);
        final Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(v -> {
            name = inputName.getText().toString();
            color = inputColor.getText().toString();
            number = Integer.valueOf(inputNumber.getText().toString());
            zip = Integer.valueOf(inputZip.getText().toString());
            temp = Double.toString(currentTemp);
            getWeather(zip);
            openMain2Activity();
            //showInputWorked();
            //showInputWorked(color);
            //showInputWorked(String.valueOf(zip));
            showInputWorked(String.valueOf(currentTemp));
        });
    }
    private void showInputWorked(String input) {
        Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();
    }
    public void openMain2Activity() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void getWeather(int zip) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + Integer.toString(zip) + ",us&appid=9217c015bb090dcf6b1c0af9b50f7a71&units=imperial";
        /*String url = "http://api.openweathermap.org/data/2.5/weather";
        JSONObject request = new JSONObject();
        try { request.put("zip", Integer.toString(zip) + ",us"); } catch (Exception e) { }
        try { request.put("appid", "9217c015bb090dcf6b1c0af9b50f7a71"); } catch (Exception e) { }
        */JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject mainObject = response.getJSONObject("main");
                    Log.d("mian to string", mainObject.toString());
                    String temp = String.valueOf(mainObject.getDouble("temp"));
                    double tempAsDouble = Double.parseDouble(temp);
                    currentTemp = tempAsDouble;
                    Log.e("currentTemp is ", Double.toString(currentTemp));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error: ", error.toString());
            }
        }
        );
        json.setShouldCache(false);
        RequestQueue request2 = Volley.newRequestQueue(this);
        request2.add(json);
        Log.d("current temp now is ", Double.toString(currentTemp));
    }
}
