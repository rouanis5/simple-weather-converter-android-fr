package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Celisius extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celisius);

        TextView title1View = findViewById(R.id.titleOne);
        TextView title2View = findViewById(R.id.titleTwo);

        Button btn = findViewById(R.id.convertBtn);

        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("type");

        String appTitle;
        String[] units = {"CELCIUS", "FAHRENHEIT", "KELVIN"};
        String title1 = "", title2 = "";

        switch(type){
            case "C":
                appTitle = units[0];
                title1 = units[1];
                title2 = units[2];
                break;
            case "F":
                appTitle = units[1];
                title1 = units[0];
                title2 = units[2];
                break;
            case "K":
                appTitle = units[2];
                title1 = units[0];
                title2 = units[1];
                break;
            default:
                appTitle = "not found";
                break;
        }
        getSupportActionBar().setTitle(appTitle);
        title1View.setText("Température en "+ title1);
        title2View.setText("Température en "+ title2);
        calculate(type);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(type);
            }
        });
    }
    public void calculate(String currentUnitType) {
        TextView t1 = findViewById(R.id.textView1);
        TextView t2 = findViewById(R.id.textView2);
        EditText et = findViewById(R.id.editText);

        if (et.getText().toString() != null){
            Double n, n1, n2;
            n = Double.parseDouble(et.getText().toString());
            switch(currentUnitType){
                case "C":
                    n1 = n * 1.8 + 32;
                    n2 = n + 273.15;
                    break;
                case "F":
                    n1 = (n - 32) / 1.8;
                    n2 = n1 + 273.15;
                    break;
                case "K":
                    n1 = n - 273.15;
                    n2 = n * 1.8 - 459.67;
                    break;
                default:
                    n1 = 0.0;
                    n2 = 0.0;
                    break;
            }
            t1.setText(n1.toString());
            t2.setText(n2.toString());
        }
    }
}