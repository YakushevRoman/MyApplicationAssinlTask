package com.example.user301.myapplicationassinltask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TaskThree extends AppCompatActivity {
    public static final String LOG = "my_log";

    MyTaskthree myTaskthree;

    Button buttonTaskThree;
    Button buttonTaskGetThree;
    TextView textViewTaskThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_three);

        textViewTaskThree = findViewById(R.id.textViewtaskThree);

        buttonTaskThree = findViewById(R.id.buttonTaskThree);
        buttonTaskThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTaskthree = new MyTaskthree();
                myTaskthree.execute();
            }
        });

        buttonTaskGetThree = findViewById(R.id.buttonGetTaskThree);
        buttonTaskGetThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });

    }

    private void showResult(){
        if (myTaskthree == null) return;
        int result = -1;

        try {
            Log.d(LOG, "showResult: " + " try to get");
            result = myTaskthree.get(1, TimeUnit.SECONDS);
            Log.d(LOG, "showResult: " + result);
            Toast.makeText(this, " get return" + result, Toast.LENGTH_SHORT).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    class MyTaskthree extends AsyncTask<Void, Void, Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textViewTaskThree.setText(R.string.begin);
            Log.d(LOG, String.valueOf(R.string.begin));
        }

        @Override
        protected Integer doInBackground(Void... voids) {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100500;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            textViewTaskThree.setText(String.valueOf(integer));
            Log.d(LOG, "onPostExecute: " + String.valueOf(integer));
        }
    }
}
