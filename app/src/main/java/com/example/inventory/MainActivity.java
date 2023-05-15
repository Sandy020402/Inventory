package com.example.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelperUser dbHelper;
    EditText TxNoInduk, TxPassword;

    public static final String FILENAME = "login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //views to object


        /*dbHelper = new DatabaseHelperUser(this);*/

        TxNoInduk = (EditText) findViewById(R.id.et_login_nomorinduk);
        TxPassword = (EditText) findViewById(R.id.et_login_password);
        Button btLogin = (Button) findViewById(R.id.btDoneRegister);


        dbHelper = new DatabaseHelperUser(this);

        Button btRegister = (Button) findViewById(R.id.btRegister);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }

        });


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no_induk = TxNoInduk.getText().toString().trim();
                String password = TxPassword.getText().toString().trim();
                System.out.println(no_induk);
                dbHelper.delete();
                /*if (res == true) {
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, DashboardUserActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }*/
            }

        });

        Button btDRegister = (Button) findViewById(R.id.btDoneRegister);

        btRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent( MainActivity.this, LoginActivity.class));
            }

        });

    }
}
