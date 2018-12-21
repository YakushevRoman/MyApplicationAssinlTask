package com.example.user301.myapplicationassinltask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class TaskTwo extends AppCompatActivity {
    Button buttonTaskTwo;
    TextView textViewTaskTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);

        textViewTaskTwo = findViewById(R.id.textViewTaskTwo);

        buttonTaskTwo = findViewById(R.id.buttonTaskTwo);
        buttonTaskTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask myTask = new MyTask();
                myTask.execute("File 1","File 2","File 3","File 4","File 5");
            }
        });
    }

    class MyTask extends AsyncTask <String, Integer, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textViewTaskTwo.setText(R.string.begin_two);
        }

        @Override
        protected Void doInBackground(String... strings) {
            int c = 0;
            for (String url: strings) {
                try {
                    downloadFile(url);
                    publishProgress(++c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textViewTaskTwo.setText("Download: " + values[0] + "files");
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textViewTaskTwo.setText(R.string.end);
        }

        private void downloadFile (String url) throws InterruptedException{
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
