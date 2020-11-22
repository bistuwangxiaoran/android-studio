package com.example.intentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView show;
    int num = 0;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = findViewById(R.id.show);
        handler = new Handler();
        findViewById(R.id.bn1).setOnClickListener(new MyThread());
        findViewById(R.id.bn2).setOnClickListener(new MyThread());
    }
    class MyThread implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            handler.post(new Runnable() {
                @SuppressLint("SetTextI18n")
                @Override
                public void run() {
                    num += 1;
                    show.setText("" + num);
                    handler.postDelayed(this, 1000);
                }
            });
        }
    }
}
