package com.example.inventory;
package kominfo.go.id.storage.halamanlogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    //private DatabaseHelperUser dbHelper;
    private EditText TxNoInduk;
    private EditText TxNama;
    private Spinner TxProdi;
    private EditText TxEmail;
    private EditText TxPassword;
    DatabaseHelperUser dbHelper;




    public static final String FILENAME = "register";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DatabaseHelperUser(this);

        TxNoInduk = (EditText) findViewById(R.id.et_);






    }


}