package com.example.sathya.countonclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button bttn;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.mytext);
        bttn = (Button) findViewById(R.id.mybutton);
        txt.setText(count);
        bttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txt.setText(count + 1);
            }
        });
    }
}
