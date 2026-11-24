package com.citomoltd.namaz_shikkha_bangla;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;

public class Splash_screen extends AppCompatActivity {

    ProgressBar progressBar;
    int progressId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBar=findViewById(R.id.progressBar);

        AdHelper.initializeAd(this);


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        });
        thread.start();


        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent=new Intent(Splash_screen.this,MainActivity.class);
                startActivity(splashIntent);
                finish();

            }
        },2500);



    }

    private void doWork(){

        for (progressId=25;progressId<=100;progressId=progressId+25){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progressId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}