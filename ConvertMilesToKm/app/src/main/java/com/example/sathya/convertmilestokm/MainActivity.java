package com.example.sathya.convertmilestokm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;
import android.view.View;

import static com.example.sathya.convertmilestokm.R.styleable.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonConvMilesToKm = (Button) findViewById(R.id.editTextMiles);
        buttonConvMilesToKm.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                EditText textBoxMiles = (EditText) findViewById(R.id.editTextMiles);
                EditText textBoxKm = (EditText) findViewById((R.id.editTextKm));
                double vMiles = Double.valueOf(textBoxMiles.getText().toString());
                double vKm = vMiles / 0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                textBoxKm.setText(formatVal.format(vKm));
            }

        });
        Button buttonConvKmToMiles = (Button) findViewById(R.id.editTextKm);
        buttonConvKmToMiles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText textBoxMiles = (EditText) findViewById(R.id.editTextMiles);
                EditText textBoxKm = (EditText) findViewById((R.id.editTextKm));
                double vKm = Double.valueOf(textBoxKm.getText().toString());
                double vMiles = vKm * 0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                textBoxMiles.setText(formatVal.format(vMiles));
            }

        });
    }}


