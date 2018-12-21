package com.example.user301.myapplicationassinltask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonOneTask;
    Button buttonTwoTask;
    Button buttonThreeTask;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOneTask = findViewById(R.id.button_one_ast);
        buttonOneTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, TaskOne.class);
                startActivity(intent);
            }
        });

        buttonTwoTask = findViewById(R.id.button_two_ast);
        buttonTwoTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, TaskTwo.class);
                startActivity(intent);
            }
        });

        buttonThreeTask = findViewById(R.id.button_three_ast);
        buttonThreeTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, TaskThree.class);
                startActivity(intent);
            }
        });
    }
}
