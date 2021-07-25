package com.example.LetsBuildAPC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


public class MainActivity extends AppCompatActivity {

    private TextView description;
    private Button choice1Button;
    private Button choice2Button;
    private Button homeButton;
    DecisionNode node;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        description = findViewById(R.id.description);
        choice1Button = findViewById(R.id.firstChoiceButton);
        choice2Button = findViewById(R.id.secondChoiceButton);
        homeButton = findViewById(R.id.home);

        DecisionMap map;

        try {
            map = new DecisionMap(getCSV());
        } catch (FileNotFoundException fe) {
            description.setText("File not found" + fe);
            return;
        }
        node = map.entryPoint();

        description.setText(node.getDescription());
        choice1Button.setText(node.getChoice1());
        choice2Button.setText(node.getChoice2());
        homeButton.setText("Home");




        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node = node.getChoice1Node();
                description.setText(node.getDescription());
                choice1Button.setText(node.getChoice1());
                choice2Button.setText(node.getChoice2());
                if(node.getChoice2().equals("-") && node.getChoice1().equals("-")){
                    choice2Button.setVisibility(View.INVISIBLE);
                    choice1Button.setText("Continue");
                }
                else if(node.getChoice2().equals("-")){
                    choice2Button.setVisibility(View.INVISIBLE);
                }
                else{
                    choice2Button.setVisibility(View.VISIBLE);
                }
                }

        });

        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                node = node.getChoice2Node();
                description.setText(node.getDescription());
                choice1Button.setText(node.getChoice1());
                choice2Button.setText(node.getChoice2());
                if(node.getChoice2().equals("-") && node.getChoice1().equals("-")){
                    choice2Button.setVisibility(View.INVISIBLE);
                    choice1Button.setText("Continue");
                }
                else if(node.getChoice2().equals("-")){
                    choice2Button.setVisibility(View.INVISIBLE);
                }
                else{
                    choice2Button.setVisibility(View.VISIBLE);
                }
                }

        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StartScreen.class));
            }
        });


        }

    public BufferedReader getCSV() {

        InputStream is = getResources().openRawResource(R.raw.mycsv);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        return reader;
    }
}