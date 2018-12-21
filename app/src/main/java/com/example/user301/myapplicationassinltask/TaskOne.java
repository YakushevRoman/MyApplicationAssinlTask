package com.example.user301.myapplicationassinltask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class TaskOne extends AppCompatActivity {
    Button buttonOne;
    TextView textViewOne;
    MyTaskOne myTaskOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);

        textViewOne = findViewById(R.id.textViewTaskOne);
        buttonOne = findViewById(R.id.buttonTaskOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTaskOne = new MyTaskOne();
                myTaskOne.execute();
            }
        });

    }

    class MyTaskOne extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textViewOne.setText(R.string.begin);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textViewOne.setText(R.string.end);
        }
    }
}
