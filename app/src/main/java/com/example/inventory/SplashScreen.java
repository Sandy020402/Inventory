package com.example.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstancestate) {

        getActionBar().hide();
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { startActivity(new Intent(SplashScreen.this, LoginActivity.class));}

        }, 3000);
    }

}