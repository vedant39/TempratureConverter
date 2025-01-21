package com.example.tempratureconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TempratureConverter extends AppCompatActivity {

    // Creating Elements in the App

    //Text field to input the value
    private EditText tempratureInput;

    //Text Field to output the value
    private EditText tempratureOutput;

    //RadioButton to convert the input value in celcius
    private RadioButton celcius;

    //Radio button to convert the value in fahrenheit
    private RadioButton fahrenheit;

    //Radio button to convert the value in kelvin
    private RadioButton kelvin;

    //Button to Convert the value
    private Button convertButton;

    //Button to Reset the value
    private Button resetButton;

    //Button to Exit the value
    private Button exitButton;

    //Method to Convert the value
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);

        //Initializing the Elements
        tempratureInput = findViewById(R.id.tempratureInput);
        tempratureOutput = findViewById(R.id.tempratureOutput);
        celcius = findViewById(R.id.celcius);
        fahrenheit = findViewById(R.id.fahrenheit);
        kelvin = findViewById(R.id.kelvin);
        convertButton = findViewById(R.id.convertButton);
        resetButton = findViewById(R.id.resetButton);
        exitButton = findViewById(R.id.exitButton);

        //Converting the value
        celcius.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    convertTemperature();
                }
            }
        });

        fahrenheit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    convertTemperature();
                }
            }
        });

        kelvin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    convertTemperature();
                }
            }
        });

        tempratureInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                convertTemperature();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Resetting the value
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempratureInput.setText("");
                tempratureOutput.setText("");
                celcius.setChecked(false);
                fahrenheit.setChecked(false);
                kelvin.setChecked(false);
            }
        });

        //Exiting the app
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void convertTemperature() {
        String input = tempratureInput.getText().toString();
        if (input.isEmpty()) {
            tempratureOutput.setText("");
            return;
        }

        double temperature = Double.parseDouble(input);

        if (celcius.isChecked()) {
            tempratureOutput.setText(String.format("%.2f°C", temperature));
        } else if (fahrenheit.isChecked()) {
            double fahrenheitValue = (temperature * 9 / 5) + 32;
            tempratureOutput.setText(String.format("%.2f°F", fahrenheitValue));
        } else if (kelvin.isChecked()) {
            double kelvinValue = temperature + 273.15;
            tempratureOutput.setText(String.format("%.2fK", kelvinValue));
        }
    }
}