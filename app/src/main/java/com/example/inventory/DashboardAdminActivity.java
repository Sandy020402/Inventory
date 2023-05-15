package com.example.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardAdminActivity extends AppCompatActivity {


    Button btTambahBarang = (Button) findViewById(R.id.buttonTambahBarang);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_admin);


        btTambahBarang.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardAdminActivity.this, RegisterActivity.class));
            }

        });






    }
}
