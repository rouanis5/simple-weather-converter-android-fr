package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Convertisseur de température");

        Button cBtn = findViewById(R.id.celciusBtn);
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTo("C");
            }
        });

        Button fBtn = findViewById(R.id.fahrenheitBtn);
        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTo("F");
            }
        });

        Button kBtn = findViewById(R.id.kelvinBtn);
        kBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTo("K");
            }
        });
    }

    public void switchTo(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);

        Intent intent = new Intent(this, Celisius.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}