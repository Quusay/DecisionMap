package com.example.LetsBuildAPC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {

    private TextView desc;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        start = findViewById(R.id.start);
        desc = findViewById(R.id.description);

        desc.setText("Let's build a PC together!");

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartScreen.this,MainActivity.class));
            }
        });{

        }
    }
}