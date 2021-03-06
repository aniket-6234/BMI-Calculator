package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    Thread timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        timer = new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (this){
                        wait(3000);
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, Home_BMI.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}